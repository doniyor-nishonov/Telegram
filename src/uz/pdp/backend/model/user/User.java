package uz.pdp.backend.model.user;

import uz.pdp.backend.model.BaseModel;

import java.util.Objects;

/**
 * The User class represents a user entity with its properties and methods.
 * It extends the BaseModel class.
 */
public class User extends BaseModel {

    private String name; // The name of the user
    private String userName; // The username of the user
    private String password; // The password of the user

    /**
     * Constructs a new User object with the specified name, username, and password.
     * @param name The name of the user.
     * @param userName The username of the user.
     * @param password The password of the user.
     */
    public User(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Returns the name of the user.
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * @param name The new name to set for the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the username of the user.
     * @return The username of the user.
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Returns the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }


    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    /**
     * Returns a hash code value for the object.
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, userName, password);
    }

    /**
     * Returns a string representation of the user including name, username, and password.
     * @return A formatted string representation of the user.
     */
    @Override
    public String toString() {
        return """
                 Name:     %s
                 UserName: %s
                 Password: %s
                """.formatted(name, userName, password);
    }
}
