package uz.pdp.backend.service.group;

import uz.pdp.backend.model.group.Group;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface GroupService extends BaseService<Group> {
    List<Group> findByName(String name);

    List<Group> fetchUserGroups(String id);
}
