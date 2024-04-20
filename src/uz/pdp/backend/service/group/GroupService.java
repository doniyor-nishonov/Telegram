
package uz.pdp.backend.service.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.service.BaseService;

import java.util.List;
/**
 * The GroupService interface provides methods to perform operations related to groups.
 * It extends the BaseService interface, which provides basic CRUD operations.
 */
public interface GroupService extends BaseService<Group> {

    /**
     * Finds groups with a specified name.
     *
     * @param name the name of the groups to search for
     * @return a list of groups with the specified name
     */
    List<Group> findByName(String name);

    /**
     * Retrieves groups associated with a specific user.
     *
     * @param id the ID of the user whose groups are to be retrieved
     * @return a list of groups associated with the specified user
     */
    List<Group> fetchUserGroups(String id);
}
