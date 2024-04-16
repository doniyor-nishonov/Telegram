package uz.pdp.backend.service.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.repository.user.UserRepository;
import uz.pdp.backend.repository.user.UserRepositoryImp;

import java.util.List;
import java.util.Objects;

public class UserServiceImp implements UserService{
    private final UserRepository userRepository = UserRepositoryImp.getInstance();
    private static UserService userService;
    public static UserService getInstance() {
        if(Objects.isNull(userService))
            userService = new UserServiceImp();
        return userService;
    }
    private UserServiceImp() {
    }

    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    @Override
    public boolean delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public boolean update(User newE) {
        return userRepository.update(newE);
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

}
