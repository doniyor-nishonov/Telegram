package uz.pdp.backend.service.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.repository.user.UserRepository;
import uz.pdp.backend.repository.user.UserRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the UserService interface.
 * This class provides methods to interact with User entities.
 */
public class UserServiceImp implements UserService {

    private final UserRepository userRepository = UserRepositoryImp.getInstance();
    private static UserService userService;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private UserServiceImp() {
    }

    /**
     * Returns a singleton instance of UserService.
     *
     * @return the instance of UserService
     */
    public static UserService getInstance() {
        if (Objects.isNull(userService))
            userService = new UserServiceImp();
        return userService;
    }

    /**
     * Adds a new user to the repository.
     *
     * @param user the user to be added
     * @return true if the user is successfully added, false otherwise
     */
    @Override
    public boolean add(User user) {
        return userRepository.add(user);
    }

    /**
     * Deletes a user from the repository by its ID.
     *
     * @param id the ID of the user to be deleted
     * @return true if the user is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return userRepository.delete(id);
    }

    /**
     * Updates an existing user in the repository.
     *
     * @param newE the updated user object
     * @return true if the user is successfully updated, false otherwise
     */
    @Override
    public boolean update(User newE) {
        return userRepository.update(newE);
    }

    /**
     * Retrieves all users from the repository.
     *
     * @return a list of all users
     */
    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    /**
     * Retrieves a user from the repository by its ID.
     *
     * @param id the ID of the user to retrieve
     * @return the user object if found, null otherwise
     */
    @Override
    public User get(String id) {
        return userRepository.get(id);
    }

    /**
     * Signs in a user using the provided login credentials.
     *
     * @param dto the DTO containing login credentials
     * @return the signed-in user if authentication is successful, null otherwise
     */
    @Override
    public User signIn(LoginDTO dto) {
        return userRepository.signIn(dto);
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return the user object if found, null otherwise
     */
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
