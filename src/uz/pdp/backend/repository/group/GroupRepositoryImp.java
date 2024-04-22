package uz.pdp.backend.repository.group;

import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.nio.path.ChildPath;
import uz.pdp.backend.nio.path.DirectoryPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The GroupRepositoryImp class implements the GroupRepository interface to provide methods for
 * accessing and managing group data using file storage.
 */
public class GroupRepositoryImp implements GroupRepository {

    private final List<Group> list; // The list of groups
    private final ListFileHandler<Group> owr = new ListFileHandler<>(DirectoryPath.DB, ChildPath.GROUPS); // The file handler for reading and writing group data
    private static GroupRepository groupRepository; // Singleton instance of GroupRepository

    /**
     * Returns a singleton instance of the GroupRepositoryImp class.
     * @return The singleton instance of GroupRepositoryImp.
     */
    public static GroupRepository getInstance() {
        if (Objects.isNull(groupRepository))
            groupRepository = new GroupRepositoryImp();
        return groupRepository;
    }

    /**
     * Constructs a new GroupRepositoryImp object and initializes the list of groups from the file.
     */
    private GroupRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a new group to the repository.
     * @param group The group to add.
     * @return true if the group is added successfully, false otherwise.
     */
    @Override
    public boolean add(Group group) {
        boolean match = list.stream().anyMatch(g -> Objects.equals(g.getName(), group.getName()));
        if (match)
            return false;
        list.add(group);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a group from the repository.
     * @param id The ID of the group to delete.
     * @return true if the group is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf(g -> Objects.equals(g.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates an existing group in the repository.
     * @param group The updated group object.
     * @return true if the group is updated successfully, false otherwise.
     */
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

    /**
     * Retrieves all groups from the repository.
     * @return A list of all groups in the repository.
     */
    @Override
    public List<Group> getAll() {
        return list;
    }

    /**
     * Retrieves a group from the repository by its ID.
     * @param id The ID of the group to retrieve.
     * @return The group with the specified ID, or null if not found.
     */
    @Override
    public Group get(String id) {
        return list.stream().filter((g) -> Objects.equals(g.getId(), id)).findFirst().orElse(null);
    }

    /**
     * Finds groups with the specified name.
     * @param name The name of the group to search for.
     * @return A list of groups with the specified name.
     */
    @Override
    public List<Group> findByName(String name) {
        return list.stream()
                .filter(group -> group.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Fetches groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of groups associated with the user.
     */
    @Override
    public List<Group> fetchUserGroups(String id) {
        return list.stream().filter((g) -> Objects.equals(g.getUserId(), id)).collect(Collectors.toList());
    }
}
