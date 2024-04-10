package uz.pdp.backend.service.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.BaseService;

public interface UserService extends BaseService<User> {
    User signIn(LoginDTO dto);
    User findByUsername(String username);
}
