
package uz.pdp.backend.service.member;

import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.service.BaseService;

import java.util.List;
/**
 * The MemberService interface provides methods to perform operations related to members.
 * It extends the BaseService interface, which provides basic CRUD operations.
 */
public interface MemberService extends BaseService<Member> {

    /**
     * Retrieves members belonging to groups associated with a specific user.
     *
     * @param id the ID of the user whose group members are to be retrieved
     * @return a list of members belonging to groups associated with the specified user
     */
    List<Member> getUserByGroups(String id);

    /**
     * Retrieves members of a specific group.
     *
     * @param groupId the ID of the group whose members are to be retrieved
     * @return a list of members of the specified group
     */
    List<Member> getMembers(String groupId);

    /**
     * Retrieves groups associated with a specific user, along with their members.
     *
     * @param id the ID of the user whose groups and members are to be retrieved
     * @return a list of members of groups associated with the specified user
     */
    List<Member> fetchUserGroups(String id);
}
