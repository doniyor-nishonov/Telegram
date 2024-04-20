package uz.pdp.backend.service.member;

import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.repository.members.MembersRepository;
import uz.pdp.backend.repository.members.MembersRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the MemberService interface.
 * This class provides methods to interact with Member entities.
 */
public class MemberServiceImp implements MemberService {

    private final MembersRepository membersRepository = MembersRepositoryImp.getInstance();
    private static MemberService memberService;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private MemberServiceImp() {
    }

    /**
     * Returns a singleton instance of MemberService.
     *
     * @return the instance of MemberService
     */
    public static MemberService getInstance() {
        if (Objects.isNull(memberService)) {
            memberService = new MemberServiceImp();
        }
        return memberService;
    }

    /**
     * Adds a new member to the repository.
     *
     * @param member the member to be added
     * @return true if the member is successfully added, false otherwise
     */
    @Override
    public boolean add(Member member) {
        return membersRepository.add(member);
    }

    /**
     * Deletes a member from the repository by its ID.
     *
     * @param id the ID of the member to be deleted
     * @return true if the member is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return membersRepository.delete(id);
    }

    /**
     * Updates an existing member in the repository.
     *
     * @param newE the updated member object
     * @return true if the member is successfully updated, false otherwise
     */
    @Override
    public boolean update(Member newE) {
        return membersRepository.update(newE);
    }

    /**
     * Retrieves all members from the repository.
     *
     * @return a list of all members
     */
    @Override
    public List<Member> getAll() {
        return membersRepository.getAll();
    }

    /**
     * Retrieves a member from the repository by its ID.
     *
     * @param id the ID of the member to retrieve
     * @return the member object if found, null otherwise
     */
    @Override
    public Member get(String id) {
        return membersRepository.get(id);
    }

    /**
     * Retrieves all members associated with a specific group.
     *
     * @param groupId the ID of the group
     * @return a list of members belonging to the specified group
     */
    @Override
    public List<Member> getMembers(String groupId) {
        return membersRepository.getMembers(groupId);
    }

    /**
     * Retrieves all user groups associated with a specific user.
     *
     * @param id the ID of the user
     * @return a list of user groups
     */
    @Override
    public List<Member> fetchUserGroups(String id) {
        return membersRepository.fetchUserGroups(id);
    }

    /**
     * Retrieves all members associated with a specific group.
     *
     * @param id the ID of the group
     * @return a list of members belonging to the specified group
     */
    @Override
    public List<Member> getUserByGroups(String id) {
        return membersRepository.getUserByGroups(id);
    }
}
