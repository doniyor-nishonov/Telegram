package uz.pdp.backend.service.member;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface MemberService extends BaseService<Member> {

    List<Member> getUserByGroups(String id);

    List<Member> getMembers(String groupId);

    List<Member> fetchUserGroups(String id);
}
