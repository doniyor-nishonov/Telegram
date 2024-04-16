package uz.pdp.backend.repository.user;

import uz.pdp.backend.DTO.LoginDTO;
import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.user.User;

import java.util.List;
import java.util.Objects;

public class UserRepositoryImp implements UserRepository {
    private final List<User> list;
    private final String filePath = "db/users.txt";
    private final ObjectWriterReader<User> owr = new ObjectWriterReader<>(filePath);
    private static UserRepository userRepository;

    public static UserRepository getInstance() {
        if(Objects.isNull(userRepository))
            userRepository = new UserRepositoryImp();
        return userRepository;
    }
    private UserRepositoryImp() {
        list = owr.readObjects();
    }
    @Override
    public User signIn(LoginDTO dto) {
        return list.stream()
                .filter((l) -> Objects.equals(dto.username(), l.getUserName())
                        && Objects.equals(dto.password(), l.getPassword()))
                .findFirst().orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return list.stream().filter((u) -> Objects.equals(u.getUserName(), username))
                .findFirst().orElse(null);
    }


    @Override
    public boolean add(User user) {
        boolean b = list.stream().anyMatch((u) -> Objects.equals(u.getUserName(), user.getUserName()));
        if (b)
            return false;
        list.add(user);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removeIf = list.removeIf((u) -> Objects.equals(u.getId(), id));
        if (removeIf) {
            owr.writeObjects(list);
        }
        return removeIf;
    }

    @Override
    public boolean update(User user) {
        int index = list.indexOf(get(user.getId()));
        if (index != -1) {
            list.set(index, user);
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
