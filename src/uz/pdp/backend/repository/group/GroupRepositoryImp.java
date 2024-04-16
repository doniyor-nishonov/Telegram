package uz.pdp.backend.repository.group;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.group.Group;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupRepositoryImp implements GroupRepository {
    private final List<Group> list;
    private final String filePath = "db/groups.txt";
    private final ObjectWriterReader<Group> owr = new ObjectWriterReader<>(filePath);
    private static GroupRepository groupRepository;

    public static GroupRepository getInstance() {
        if (Objects.isNull(groupRepository))
            groupRepository = new GroupRepositoryImp();
        return groupRepository;
    }

    private GroupRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public boolean add(Group group) {
        boolean match = list.stream().anyMatch(g -> Objects.equals(g.getName(), group.getName()));
        if (match)
            return false;
        list.add(group);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf(g -> Objects.equals(g.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(Group group) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), group.getId())) {
                list.set(i, group);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Group> getAll() {
        return list;
    }

    @Override
    public Group get(String id) {
        return list.stream().filter((g) -> Objects.equals(g.getId(), id)).findFirst().orElse(null);
    }

    @Override
    public List<Group> findByName(String name) {
        return list.stream()
                .filter(group -> group.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Group> fetchUserGroups(String id) {
        return list.stream().filter((g) -> Objects.equals(g.getUserId(), id)).collect(Collectors.toList());
    }
}
