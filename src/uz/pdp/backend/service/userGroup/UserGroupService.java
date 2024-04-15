package uz.pdp.backend.service.userGroup;

import uz.pdp.backend.model.userGroup.UserGroup;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface UserGroupService extends BaseService<UserGroup> {

    List<UserGroup> getUserByGroups(String id);

    List<UserGroup> getMembers(String groupId);
}
