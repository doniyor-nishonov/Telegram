package uz.pdp.backend.service.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.repository.group.GroupRepository;
import uz.pdp.backend.repository.group.GroupRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * The GroupServiceImp class implements the GroupService interface and provides
 * functionality to perform operations on groups.
 */
public class GroupServiceImp implements GroupService {

    private final GroupRepository groupRepository = GroupRepositoryImp.getInstance();
    private static GroupService groupService;

    /**
     * Retrieves an instance of the GroupServiceImp class.
     *
     * @return an instance of the GroupServiceImp class
     */
    public static GroupService getInstance() {
        if (Objects.isNull(groupService))
            groupService = new GroupServiceImp();
        return groupService;
    }

    private GroupServiceImp() {
    }

    /**
     * Adds a new group.
     *
     * @param group the group to add
     * @return true if the group is added successfully, false otherwise
     */
    @Override
    public boolean add(Group group) {
        return groupRepository.add(group);
    }

    /**
     * Deletes a group by its ID.
     *
     * @param id the ID of the group to delete
     * @return true if the group is deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return groupRepository.delete(id);
    }

    /**
     * Updates a group.
     *
     * @param newGroup the updated group
     * @return true if the group is updated successfully, false otherwise
     */
    @Override
    public boolean update(Group newGroup) {
        return groupRepository.update(newGroup);
    }

    /**
     * Retrieves all groups.
     *
     * @return a list of all groups
     */
    @Override
    public List<Group> getAll() {
        return groupRepository.getAll();
    }

    /**
     * Retrieves a group by its ID.
     *
     * @param id the ID of the group to retrieve
     * @return the group with the specified ID
     */
    @Override
    public Group get(String id) {
        return groupRepository.get(id);
    }

    /**
     * Finds groups with a specified name.
     *
     * @param name the name of the groups to search for
     * @return a list of groups with the specified name
     */
    @Override
    public List<Group> findByName(String name) {
        return groupRepository.findByName(name);
    }

    /**
     * Retrieves groups associated with a specific user.
     *
     * @param id the ID of the user whose groups are to be retrieved
     * @return a list of groups associated with the specified user
     */
    @Override
    public List<Group> fetchUserGroups(String id) {
        return groupRepository.fetchUserGroups(id);
    }
}
