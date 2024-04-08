package uz.pdp.backend.service.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.repository.user.UserRepository;
import uz.pdp.backend.repository.user.UserRepositoryImp;

import java.util.List;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository = new UserRepositoryImp();
    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean update(String id, User newE) {
        return userRepository.update(id,newE);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User get(String id) {
        return userRepository.get(id);
    }

    @Override
    public User signIn(LoginDTO dto) {
        return userRepository.signIn(dto);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean block(String userId) {
        return userRepository.block(userId);
    }

    @Override
    public boolean unBlock(String userId) {
        return userRepository.unBlock(userId);
    }
}
