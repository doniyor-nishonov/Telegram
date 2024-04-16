package uz.pdp.backend.service.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.repository.post.PostRepository;
import uz.pdp.backend.repository.post.PostRepositoryImp;

import java.util.List;
import java.util.Objects;

public class PostServiceImp implements PostService{
    private final PostRepository postRepository = PostRepositoryImp.getInstance();
    private static PostService postService;
    public static PostService getInstance() {
        if(Objects.isNull(postService))
            postService = new PostServiceImp();
        return postService;
    }
    private PostServiceImp() {
    }

    @Override
    public boolean add(Post post) {
        return postRepository.add(post);
    }

    @Override
    public boolean delete(String id) {
        return postRepository.delete(id);
    }

    @Override
    public boolean update(Post newE) {
        return postRepository.update(newE);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post get(String id) {
        return postRepository.get(id);
    }

    @Override
    public List<Post> getPostChannels(String channelId) {
        return postRepository.getPostChannels(channelId);
    }
}
