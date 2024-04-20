
package uz.pdp.backend.repository.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.repository.BaseRepository;
/**
 * The UserRepository interface provides methods for CRUD operations
 * specific to User entities and additional operations related to user management.
 */
public interface UserRepository extends BaseRepository<User> {

    /**
     * Signs in a user based on the provided login credentials.
     *
     * @param dto The LoginDTO containing user credentials
     * @return The signed-in user, or null if the credentials are invalid
     */
    User signIn(LoginDTO dto);

    /**
     * Finds a user by their username.
     *
     * @param username The username of the user to find
     * @return The user with the provided username, or null if not found
     */
    User findByUsername(String username);
}
