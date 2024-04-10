package uz.pdp.backend.service.userGroup;

import uz.pdp.backend.model.userGroup.UserGroup;
import uz.pdp.backend.repository.userGroup.UserGroupRepository;
import uz.pdp.backend.repository.userGroup.UserGroupRepositoryImp;

import java.util.List;
import java.util.Objects;

public class UserGroupServiceImp implements UserGroupService {
    private final UserGroupRepository userGroupRepository = UserGroupRepositoryImp.getInstance();
    private static UserGroupService userGroupService;
    public static UserGroupService getInstance() {
        if(Objects.isNull(userGroupService)) {
            userGroupService = new UserGroupServiceImp();
        }
        return userGroupService;
    }
    private UserGroupServiceImp() {
    }

    @Override
    public boolean add(UserGroup userGroup) {
        return userGroupRepository.add(userGroup);
    }

    @Override
    public boolean delete(String id) {
        return userGroupRepository.delete(id);
    }

    @Override
    public boolean update(String id, UserGroup newE) {
        return userGroupRepository.update(id, newE);
    }

    @Override
    public List<UserGroup> getAll() {
        return userGroupRepository.getAll();
    }

    @Override
    public UserGroup get(String id) {
        return userGroupRepository.get(id);
    }
}
