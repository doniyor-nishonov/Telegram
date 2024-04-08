package uz.pdp.backend.repository.post;

import uz.pdp.backend.model.post.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PostRepositoryImp implements PostRepository {
    private final List<Post> list = new ArrayList<>();

    @Override
    public boolean add(Post post) {
        if(Objects.isNull(post))
            return false;
        list.add(post);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return list.removeIf((post) -> Objects.equals(post.getId(), id));
    }

    @Override
    public boolean update(String id, Post newE) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.set(i, newE);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Post> getAll() {
        return list;
    }

    @Override
    public Post get(String id) {
        return list.stream().filter((p)->Objects.equals(p.getId(),id))
                .findFirst().orElse(null);
    }
}
