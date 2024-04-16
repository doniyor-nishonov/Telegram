package uz.pdp.backend.service.member;

import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.repository.members.MembersRepository;
import uz.pdp.backend.repository.members.MembersRepositoryImp;

import java.util.List;
import java.util.Objects;

public class MemberServiceImp implements MemberService {
    private final MembersRepository membersRepository = MembersRepositoryImp.getInstance();
    private static MemberService memberService;
    public static MemberService getInstance() {
        if(Objects.isNull(memberService)) {
            memberService = new MemberServiceImp();
        }
        return memberService;
    }
    private MemberServiceImp() {
    }


    @Override
    public boolean add(Member member) {
        return membersRepository.add(member);
    }

    @Override
    public boolean delete(String id) {
        return membersRepository.delete(id);
    }

    @Override
    public boolean update(Member newE) {
        return membersRepository.update(newE);
    }

    @Override
    public List<Member> getAll() {
        return membersRepository.getAll();
    }

    @Override
    public Member get(String id) {
        return membersRepository.get(id);
    }

    @Override
    public List<Member> getUserByGroups(String id) {
        return membersRepository.getUserByGroups(id);
    }

    @Override
    public List<Member> getMembers(String groupId) {
        return membersRepository.getMembers(groupId);
    }

    @Override
    public List<Member> fetchUserGroups(String id) {
        return membersRepository.fetchUserGroups(id);
    }
}
