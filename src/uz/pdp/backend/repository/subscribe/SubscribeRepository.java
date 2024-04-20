
package uz.pdp.backend.repository.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;
/**
 * The SubscribeRepository interface provides methods for CRUD operations
 * specific to Subscribe entities and additional operations related to subscriptions.
 */
public interface SubscribeRepository extends BaseRepository<Subscribe> {

    /**
     * Retrieves all subscriptions of a user.
     *
     * @param id The ID of the user
     * @return A list of subscriptions associated with the provided user ID
     */
    List<Subscribe> getUserSubscribes(String id);

    /**
     * Retrieves all members of a channel.
     *
     * @param id The ID of the channel
     * @return A list of subscribers associated with the provided channel ID
     */
    List<Subscribe> fetchChannelMembers(String id);

    /**
     * Retrieves all channels subscribed by a user.
     *
     * @param id The ID of the user
     * @return A list of subscriptions associated with the provided user ID
     */
    List<Subscribe> fetchChannelUser(String id);
}
