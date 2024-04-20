package uz.pdp.backend.repository.members;

import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

/**
 * The MembersRepository interface provides methods for accessing and managing member data in the database.
 * It extends the BaseRepository interface.
 */
public interface MembersRepository extends BaseRepository<Member> {

    /**
     * Retrieves members of groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of members of groups associated with the user.
     */
    List<Member> getUserByGroups(String id);

    /**
     * Retrieves members of the specified group.
     * @param groupId The ID of the group.
     * @return A list of members of the specified group.
     */
    List<Member> getMembers(String groupId);

    /**
     * Fetches groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of groups associated with the user.
     */
    List<Member> fetchUserGroups(String id);
}
