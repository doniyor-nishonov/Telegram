
package uz.pdp.backend.repository.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;
/**
 * The PostRepository interface provides methods for CRUD operations
 * specific to Post entities and additional operations related to posts.
 */
public interface PostRepository extends BaseRepository<Post> {

    /**
     * Retrieves all posts associated with a specific channel.
     *
     * @param channelId The ID of the channel
     * @return A list of posts associated with the provided channel ID
     */
    List<Post> getPostChannels(String channelId);
}
