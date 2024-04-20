package uz.pdp.backend.repository.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

/**
 * The GroupRepository interface provides methods for accessing and managing group data in the database.
 * It extends the BaseRepository interface.
 */
public interface GroupRepository extends BaseRepository<Group> {

    /**
     * Finds groups with the specified name.
     * @param name The name of the group to search for.
     * @return A list of groups with the specified name.
     */
    List<Group> findByName(String name);

    /**
     * Fetches groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of groups associated with the user.
     */
    List<Group> fetchUserGroups(String id);
}
