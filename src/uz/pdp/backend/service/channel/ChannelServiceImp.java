package uz.pdp.backend.service.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.repository.channel.ChannelRepository;
import uz.pdp.backend.repository.channel.ChannelRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * The ChannelServiceImp class implements the ChannelService interface and provides
 * functionality to perform operations on channels.
 */
public class ChannelServiceImp implements ChannelService {

    private final ChannelRepository channelRepository = ChannelRepositoryImp.getInstance();
    private static ChannelService channelService;

    /**
     * Retrieves an instance of the ChannelServiceImp class.
     *
     * @return an instance of the ChannelServiceImp class
     */
    public static ChannelService getInstance() {
        if (Objects.isNull(channelService))
            channelService = new ChannelServiceImp();
        return channelService;
    }

    private ChannelServiceImp() {
    }

    /**
     * Adds a new channel.
     *
     * @param channel the channel to add
     * @return true if the channel is added successfully, false otherwise
     */
    @Override
    public boolean add(Channel channel) {
        return channelRepository.add(channel);
    }

    /**
     * Deletes a channel by its ID.
     *
     * @param id the ID of the channel to delete
     * @return true if the channel is deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return channelRepository.delete(id);
    }

    /**
     * Updates a channel.
     *
     * @param newE the updated channel
     * @return true if the channel is updated successfully, false otherwise
     */
    @Override
    public boolean update(Channel newE) {
        return channelRepository.update(newE);
    }

    /**
     * Retrieves all channels.
     *
     * @return a list of all channels
     */
    @Override
    public List<Channel> getAll() {
        return channelRepository.getAll();
    }

    /**
     * Retrieves a channel by its ID.
     *
     * @param id the ID of the channel to retrieve
     * @return the channel with the specified ID
     */
    @Override
    public Channel get(String id) {
        return channelRepository.get(id);
    }

    /**
     * Finds channels with a specified name.
     *
     * @param name the name of the channels to search for
     * @return a list of channels with the specified name
     */
    @Override
    public List<Channel> findWithName(String name) {
        return channelRepository.findWithName(name);
    }
}
