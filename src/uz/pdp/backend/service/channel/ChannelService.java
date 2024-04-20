package uz.pdp.backend.service.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.service.BaseService;

import java.util.List;
/**
 * The ChannelService interface provides methods to perform operations related to channels.
 * It extends the BaseService interface, which provides basic CRUD operations.
 */
public interface ChannelService extends BaseService<Channel> {
    /**
     * Finds channels with a specified name.
     *
     * @param name the name of the channels to search for
     * @return a list of channels with the specified name
     */
    List<Channel> findWithName(String name);
}
