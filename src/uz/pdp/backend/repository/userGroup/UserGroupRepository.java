package uz.pdp.backend.repository.userGroup;

import uz.pdp.backend.model.userGroup.UserGroup;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface UserGroupRepository extends BaseRepository<UserGroup> {

    List<UserGroup> getUserByGroups(String id);
}
