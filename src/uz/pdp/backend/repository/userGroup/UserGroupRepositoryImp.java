package uz.pdp.backend.repository.userGroup;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.userGroup.UserGroup;

import java.util.List;
import java.util.Objects;

public class UserGroupRepositoryImp implements UserGroupRepository {
    private final List<UserGroup> list;
    private final String filePath = "db/userGroups.txt";
    private final ObjectWriterReader<UserGroup> owr = new ObjectWriterReader<>(filePath);
    private static UserGroupRepository userGroupRepository;

    public static UserGroupRepository getInstance() {
        if(Objects.isNull(userGroupRepository))
            userGroupRepository = new UserGroupRepositoryImp();
        return userGroupRepository;
    }
    private UserGroupRepositoryImp() {
        list = owr.readObjects();
    }
    @Override
    public boolean add(UserGroup userGroup) {
        boolean match = list.stream().anyMatch((u) -> Objects.equals(u.getUserId(), userGroup.getUserId())
                && Objects.equals(u.getGroupId(), userGroup.getGroupId()));
        if (match)
            return false;
        list.add(userGroup);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((u) -> Objects.equals(u.getUserId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, UserGroup newE) {
        for (int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).getUserId(), id)){
                list.set(i, newE);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<UserGroup> getAll() {
        return list;
    }

    @Override
    public UserGroup get(String id) {
        return list.stream().filter((u) -> Objects.equals(u.getUserId(), id))
                .findFirst().orElse(null);
    }
}
