package uz.pdp.backend.repository.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.repository.BaseRepository;

public interface UserRepository extends BaseRepository<User> {
    User signIn(LoginDTO dto);
    User findByUsername(String username);
    boolean block(String userId);
    boolean unBlock(String userId);
}
