package uz.pdp.backend.service.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.repository.post.PostRepository;
import uz.pdp.backend.repository.post.PostRepositoryImp;

import java.util.List;

public class PostServiceImp implements PostService{
    private final PostRepository postRepository = new PostRepositoryImp();
    @Override
    public boolean add(Post post) {
        return postRepository.add(post);
    }

    @Override
    public boolean delete(String id) {
        return postRepository.delete(id);
    }

    @Override
    public boolean update(String id, Post newE) {
        return postRepository.update(id, newE);
    }

    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public Post get(String id) {
        return postRepository.get(id);
    }
}