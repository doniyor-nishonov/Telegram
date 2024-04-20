package uz.pdp.backend.repository.members;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.member.Member;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The MembersRepositoryImp class implements the MembersRepository interface to provide methods for
 * accessing and managing member data using file storage.
 */
public class MembersRepositoryImp implements MembersRepository {

    private final List<Member> list; // The list of members
    private final String filePath = "db/members.txt"; // The file path for storing member data
    private final ListFileHandler<Member> owr = new ListFileHandler<>(filePath); // The file handler for reading and writing member data
    private static MembersRepository membersRepository; // Singleton instance of MembersRepository

    /**
     * Returns a singleton instance of the MembersRepositoryImp class.
     * @return The singleton instance of MembersRepositoryImp.
     */
    public static MembersRepository getInstance() {
        if (Objects.isNull(membersRepository))
            membersRepository = new MembersRepositoryImp();
        return membersRepository;
    }

    /**
     * Constructs a new MembersRepositoryImp object and initializes the list of members from the file.
     */
    private MembersRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a new member to the repository.
     * @param member The member to add.
     * @return true if the member is added successfully, false otherwise.
     */
    @Override
    public boolean add(Member member) {
        boolean match = list.stream().anyMatch((u) -> Objects.equals(u.getUserId(), member.getUserId())
                && Objects.equals(u.getGroupId(), member.getGroupId()));
        if (match)
            return false;
        list.add(member);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a member from the repository.
     * @param id The ID of the member to delete.
     * @return true if the member is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf(m -> Objects.equals(m.getId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates an existing member in the repository.
     * @param member The updated member object.
     * @return true if the member is updated successfully, false otherwise.
     */
    @Override
    public boolean update(Member member) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), member.getId())) {
                list.set(i, member);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all members from the repository.
     * @return A list of all members in the repository.
     */
    @Override
    public List<Member> getAll() {
        return list;
    }

    /**
     * Retrieves a member from the repository by its ID.
     * @param id The ID of the member to retrieve.
     * @return The member with the specified ID, or null if not found.
     */
    @Override
    public Member get(String id) {
        return list.stream().filter((u) -> Objects.equals(u.getUserId(), id))
                .findFirst().orElse(null);
    }

    /**
     * Retrieves members of groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of members of groups associated with the user.
     */
    @Override
    public List<Member> getUserByGroups(String id) {
        return list.stream().filter(u -> !Objects.equals(u.getRole(), Role.BLOCK)
                        && Objects.equals(u.getUserId(), id))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves members of the specified group.
     * @param groupId The ID of the group.
     * @return A list of members of the specified group.
     */
    @Override
    public List<Member> getMembers(String groupId) {
        return list.stream().filter(m -> Objects.equals(m.getGroupId(), groupId))
                .collect(Collectors.toList());
    }

    /**
     * Fetches groups associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of groups associated with the user.
     */
    @Override
    public List<Member> fetchUserGroups(String id) {
        return list.stream().filter(m -> Objects.equals(m.getUserId(), id)
                        && Objects.equals(m.getRole(), Role.ADMIN))
                .collect(Collectors.toList());
    }
}
