package uz.pdp.backend.repository.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface GroupRepository extends BaseRepository<Group> {
    List<Group> findByName(String name);

    List<Group> fetchUserGroups(String id);
}
