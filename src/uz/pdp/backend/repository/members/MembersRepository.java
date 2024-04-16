package uz.pdp.backend.repository.members;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.model.member.Member;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface MembersRepository extends BaseRepository<Member> {

    List<Member> getUserByGroups(String id);

    List<Member> getMembers(String groupId);

    List<Member> fetchUserGroups(String id);
}
