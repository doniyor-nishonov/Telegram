package uz.pdp.backend.service.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.repository.group.GroupRepository;
import uz.pdp.backend.repository.group.GroupRepositoryImp;

import java.util.List;
import java.util.Objects;

public class GroupServiceImp implements GroupService{
    private final GroupRepository groupRepository = GroupRepositoryImp.getInstance();
    private static GroupService groupService;
    public static GroupService getInstance() {
        if(Objects.isNull(groupService))
            groupService = new GroupServiceImp();
        return groupService;
    }
    private GroupServiceImp(){}
    @Override
    public boolean add(Group group) {
        return groupRepository.add(group);
    }

    @Override
    public boolean delete(String id) {
        return groupRepository.delete(id);
    }

    @Override
    public boolean update(Group newGroup) {
        return groupRepository.update(newGroup);
    }

    @Override
    public List<Group> getAll() {
        return groupRepository.getAll();
    }

    @Override
    public Group get(String id) {
        return groupRepository.get(id);
    }

    @Override
    public List<Group> findByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public List<Group> fetchUserGroups(String id) {
        return groupRepository.fetchUserGroups(id);
    }
}
