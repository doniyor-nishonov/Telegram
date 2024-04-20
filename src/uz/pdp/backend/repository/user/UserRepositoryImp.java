package uz.pdp.backend.repository.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.user.User;

import java.util.List;
import java.util.Objects;
/**
 * The UserRepositoryImp class implements the UserRepository interface
 * and provides methods to perform CRUD operations on User objects.
 */
public class UserRepositoryImp implements UserRepository {

    private final List<User> list;
    private final String filePath = "db/users.txt";
    private final ListFileHandler<User> owr = new ListFileHandler<>(filePath);
    private static UserRepository userRepository;

    /**
     * Returns a singleton instance of UserRepositoryImp.
     *
     * @return The singleton instance of UserRepositoryImp
     */
    public static UserRepository getInstance() {
        if(Objects.isNull(userRepository))
            userRepository = new UserRepositoryImp();
        return userRepository;
    }

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of users by reading from file.
     */
    private UserRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Signs in a user based on the provided login credentials.
     *
     * @param dto The LoginDTO containing user credentials
     * @return The signed-in user, or null if the credentials are invalid
     */
    @Override
    public User signIn(LoginDTO dto) {
        return list.stream()
                .filter((l) -> Objects.equals(dto.username(), l.getUserName())
                        && Objects.equals(dto.password(), l.getPassword()))
                .findFirst().orElse(null);
    }

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find
     * @return The user with the provided username, or null if not found
     */
    @Override
    public User findByUsername(String username) {
        return list.stream().filter((u) -> Objects.equals(u.getUserName(), username))
                .findFirst().orElse(null);
    }

    /**
     * Adds a user to the repository.
     *
     * @param user The user to add
     * @return true if the user was added successfully, false otherwise
     */
    @Override
    public boolean add(User user) {
        boolean b = list.stream().anyMatch((u) -> Objects.equals(u.getUserName(), user.getUserName()));
        if (b)
            return false;
        list.add(user);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a user from the repository based on its ID.
     *
     * @param id The ID of the user to delete
     * @return true if the user was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        boolean removeIf = list.removeIf((u) -> Objects.equals(u.getId(), id));
        if (removeIf) {
            owr.writeObjects(list);
        }
        return removeIf;
    }

    /**
     * Updates a user in the repository.
     *
     * @param user The updated user
     * @return true if the user was updated successfully, false otherwise
     */
    @Override
    public boolean update(User user) {
        int index = list.indexOf(get(user.getId()));
        if (index != -1) {
            list.set(index, user);
            return true;
        }
        return false;
    }

    /**
     * Retrieves all users from the repository.
     *
     * @return A list of all users
     */
    @Override
    public List<User> getAll() {
        return list;
    }

    /**
     * Retrieves a user from the repository based on its ID.
     *
     * @param id The ID of the user to retrieve
     * @return The user with the provided ID, or null if not found
     */
    @Override
    public User get(String id) {
        return list.stream().filter((l) -> Objects.equals(l.getId(), id))
                .findFirst().orElse(null);
    }
}
