package uz.pdp.backend.model.user;

import uz.pdp.backend.model.BaseModel;

import java.io.Serializable;
import java.util.Objects;

import static uz.pdp.frontend.Utils.*;

public class User extends BaseModel implements Serializable {
    private String name;
    private String username;
    private String password;
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, password);
    }

    @Override
    public String toString() {
        return  GREEN + "Name->         " + STOP + name + "\n" +
                GREEN + "Username->     " + STOP + username + "\n" +
                GREEN + "Password->     " + STOP + password;
    }
}
