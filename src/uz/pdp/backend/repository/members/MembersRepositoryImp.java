package uz.pdp.backend.repository.members;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.member.Member;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MembersRepositoryImp implements MembersRepository {
    private final List<Member> list;
    private final String filePath = "db/userGroups.txt";
    private final ObjectWriterReader<Member> owr = new ObjectWriterReader<>(filePath);
    private static MembersRepository membersRepository;

    public static MembersRepository getInstance() {
        if(Objects.isNull(membersRepository))
            membersRepository = new MembersRepositoryImp();
        return membersRepository;
    }
    private MembersRepositoryImp() {
        list = owr.readObjects();
    }
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

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((u) -> Objects.equals(u.getId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, Member newE) {
        for (int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).getUserId(), id)){
                list.set(i, newE);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Member> getAll() {
        return list;
    }

    @Override
    public Member get(String id) {
        return list.stream().filter((u) -> Objects.equals(u.getUserId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Member> getUserByGroups(String id) {
        return list.stream().filter(u->Objects.equals(u.getUserId(),id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> getMembers(String groupId) {
        return list.stream().filter(m->Objects.equals(m.getGroupId(),groupId))
                .collect(Collectors.toList());
    }
}
