package uz.pdp.backend.service.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.service.BaseService;

import java.util.List;

/**
 * Service interface for managing Subscribe entities.
 * Extends the BaseService interface.
 */
public interface SubscribeService extends BaseService<Subscribe> {

    /**
     * Retrieves all subscriptions of a user.
     *
     * @param id the ID of the user
     * @return a list of subscriptions of the user
     */
    List<Subscribe> getUserSubscribes(String id);

    /**
     * Retrieves all members of a channel.
     *
     * @param id the ID of the channel
     * @return a list of members of the channel
     */
    List<Subscribe> fetchChannelMembers(String id);

    /**
     * Retrieves all users subscribed to a channel.
     *
     * @param id the ID of the channel
     * @return a list of users subscribed to the channel
     */
    List<Subscribe> fetchChannelUser(String id);

}
