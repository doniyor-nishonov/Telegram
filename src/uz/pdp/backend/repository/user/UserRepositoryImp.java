package uz.pdp.backend.repository.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.io.ObjectReader;
import uz.pdp.backend.io.ObjectWriter;
import uz.pdp.backend.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImp implements UserRepository {
    private final List<User> list;
    private final String filePath = "db/users.txt";
    private final ObjectReader<User> objectReader;
    private final ObjectWriter<User> objectWriter;

    public UserRepositoryImp() {
        objectReader = new ObjectReader<>(filePath);
        objectWriter = new ObjectWriter<>(filePath);
        list = objectReader.readObjects();
    }

    /*{
        list.add(new User("Doniyor", "d", "d"));
        list.add(new User("Mansur", "m", "m"));
        list.add(new User("Sardor", "s", "s"));
        list.add(new User("Javlon", "j", "j"));
        list.add(new User("Ali", "a", "a"));
    }
*/
    @Override
    public User signIn(LoginDTO dto) {
        return list.stream()
                .filter((l) -> Objects.equals(dto.username(), l.getUsername())
                        && Objects.equals(dto.password(), l.getPassword()))
                .findFirst().orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return list.stream().filter((u) -> Objects.equals(u.getUsername(), username))
                .findFirst().orElse(null);
    }

    @Override
    public boolean block(String userId) {
        return false;
    }

    @Override
    public boolean unBlock(String userId) {
        return false;
    }

    @Override
    public boolean add(User user) {
        boolean b = list.stream().anyMatch((u) -> Objects.equals(u.getUsername(), user.getUsername()));
        if (b)
            return false;
        list.add(user);
        objectWriter.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removeIf = list.removeIf((u) -> Objects.equals(u.getId(), id));
        if (removeIf) {
            objectWriter.writeObjects(list);
        }
        return removeIf;
    }

    @Override
    public boolean update(String id, User newE) {
        int index = list.indexOf(get(id));
        if (index != -1) {
            list.set(index, newE);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public User get(String id) {
        return list.stream().filter((l) -> Objects.equals(l.getId(), id))
                .findFirst().orElse(null);
    }
}
