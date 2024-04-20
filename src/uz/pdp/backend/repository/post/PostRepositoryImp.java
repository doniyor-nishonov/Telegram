
package uz.pdp.backend.repository.post;

import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.nio.path.ChildPath;
import uz.pdp.backend.nio.path.DirectoryPath;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The PostRepositoryImp class implements the PostRepository interface and provides
 * methods to perform CRUD operations on Post objects.
 */
public class PostRepositoryImp implements PostRepository {

    private final List<Post> list;
    private final ListFileHandler<Post> owr = new ListFileHandler<>(DirectoryPath.DB, ChildPath.POSTS);
    private static PostRepository postRepository;

    /**
     * Returns a singleton instance of PostRepositoryImp.
     *
     * @return The singleton instance of PostRepositoryImp
     */
    public static PostRepository getInstance() {
        if (Objects.isNull(postRepository))
            postRepository = new PostRepositoryImp();
        return postRepository;
    }

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of posts by reading from file.
     */
    private PostRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a post to the repository.
     *
     * @param post The post to add
     * @return true if the post was added successfully, false otherwise
     */
    @Override
    public boolean add(Post post) {
        if (Objects.isNull(post))
            return false;
        list.add(post);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a post from the repository based on its ID.
     *
     * @param id The ID of the post to delete
     * @return true if the post was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((post) -> Objects.equals(post.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates a post in the repository.
     *
     * @param post The updated post
     * @return true if the post was updated successfully, false otherwise
     */
    @Override
    public boolean update(Post post) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), post.getId())) {
                list.set(i, post);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all posts from the repository.
     *
     * @return A list of all posts
     */
    @Override
    public List<Post> getAll() {
        return list;
    }

    /**
     * Retrieves a post from the repository based on its ID.
     *
     * @param id The ID of the post to retrieve
     * @return The post with the provided ID, or null if not found
     */
    @Override
    public Post get(String id) {
        return list.stream().filter((p) -> Objects.equals(p.getId(), id))
                .findFirst().orElse(null);
    }

    /**
     * Retrieves all posts associated with a specific channel.
     *
     * @param channelId The ID of the channel
     * @return A list of posts associated with the provided channel ID
     */
    @Override
    public List<Post> getPostChannels(String channelId) {
        return list.stream()
                .filter(post -> Objects.equals(post.getChannelId(), channelId))
                .collect(Collectors.toList());
    }
}
