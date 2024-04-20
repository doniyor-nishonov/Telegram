package uz.pdp.backend.service.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.service.BaseService;

import java.util.List;

/**
 * Service interface for managing Post entities.
 * Extends the BaseService interface.
 */
public interface PostService extends BaseService<Post> {

    /**
     * Retrieves all posts belonging to a specific channel.
     *
     * @param channelId the ID of the channel
     * @return a list of posts belonging to the specified channel
     */
    List<Post> getPostChannels(String channelId);
}
