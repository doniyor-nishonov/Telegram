package uz.pdp.backend.repository.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

/**
 * The ChannelRepository interface provides methods for accessing and managing channel data in the database.
 * It extends the BaseRepository interface.
 */
public interface ChannelRepository extends BaseRepository<Channel> {

    /**
     * Retrieves a list of channels associated with the specified user ID.
     * @param userId The ID of the user.
     * @return A list of channels associated with the user.
     */
    List<Channel> getChannelByUser(String userId);

    /**
     * Finds channels with the specified name.
     * @param name The name of the channel to search for.
     * @return A list of channels with the specified name.
     */
    List<Channel> findWithName(String name);
}
