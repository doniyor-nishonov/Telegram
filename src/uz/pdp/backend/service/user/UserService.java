package uz.pdp.backend.service.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.model.user.User;
import uz.pdp.backend.service.BaseService;

/**
 * Service interface for managing User entities.
 * Extends the BaseService interface.
 */
public interface UserService extends BaseService<User> {

    /**
     * Signs in a user using the provided login credentials.
     *
     * @param dto the DTO containing login credentials
     * @return the signed-in user if authentication is successful, null otherwise
     */
    User signIn(LoginDTO dto);

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user to find
     * @return the user object if found, null otherwise
     */
    User findByUsername(String username);
}
