package uz.pdp.backend.repository.post;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.post.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PostRepositoryImp implements PostRepository {
    private final List<Post> list;
    private final String filePath = "db/posts.txt";
    private final ObjectWriterReader<Post> owr = new ObjectWriterReader<>(filePath);
    private static PostRepository postRepository;

    public static PostRepository getInstance() {
        if (Objects.isNull(postRepository))
            postRepository = new PostRepositoryImp();
        return postRepository;
    }

    private PostRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public boolean add(Post post) {
        if (Objects.isNull(post))
            return false;
        list.add(post);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((post) -> Objects.equals(post.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, Post post) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.set(i, post);
                owr.writeObjects(list);
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
        return list.stream().filter((p) -> Objects.equals(p.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Post> getPostChannels(String channelId) {
        return list.stream()
                .filter(post -> Objects.equals(post.getChannelId(), channelId))
                .collect(Collectors.toList());
    }

}
