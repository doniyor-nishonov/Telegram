package uz.pdp.backend.service.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.repository.post.PostRepository;
import uz.pdp.backend.repository.post.PostRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the PostService interface.
 * This class provides methods to interact with Post entities.
 */
public class PostServiceImp implements PostService {

    private final PostRepository postRepository = PostRepositoryImp.getInstance();
    private static PostService postService;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private PostServiceImp() {
    }

    /**
     * Returns a singleton instance of PostService.
     *
     * @return the instance of PostService
     */
    public static PostService getInstance() {
        if (Objects.isNull(postService))
            postService = new PostServiceImp();
        return postService;
    }

    /**
     * Adds a new post to the repository.
     *
     * @param post the post to be added
     * @return true if the post is successfully added, false otherwise
     */
    @Override
    public boolean add(Post post) {
        return postRepository.add(post);
    }

    /**
     * Deletes a post from the repository by its ID.
     *
     * @param id the ID of the post to be deleted
     * @return true if the post is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return postRepository.delete(id);
    }

    /**
     * Updates an existing post in the repository.
     *
     * @param newE the updated post object
     * @return true if the post is successfully updated, false otherwise
     */
    @Override
    public boolean update(Post newE) {
        return postRepository.update(newE);
    }

    /**
     * Retrieves all posts from the repository.
     *
     * @return a list of all posts
     */
    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    /**
     * Retrieves a post from the repository by its ID.
     *
     * @param id the ID of the post to retrieve
     * @return the post object if found, null otherwise
     */
    @Override
    public Post get(String id) {
        return postRepository.get(id);
    }

    /**
     * Retrieves all posts belonging to a specific channel.
     *
     * @param channelId the ID of the channel
     * @return a list of posts belonging to the specified channel
     */
    @Override
    public List<Post> getPostChannels(String channelId) {
        return postRepository.getPostChannels(channelId);
    }
}
