package uz.pdp.backend.repository.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.nio.path.ChildPath;
import uz.pdp.backend.nio.path.DirectoryPath;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The ChannelRepositoryImp class implements the ChannelRepository interface to provide methods for
 * accessing and managing channel data using file storage.
 */
public class ChannelRepositoryImp implements ChannelRepository {

    private final List<Channel> list; // The list of channels
    private final ListFileHandler<Channel> owr = new ListFileHandler<>(DirectoryPath.DB, ChildPath.CHANNELS); // The file handler for reading and writing channel data
    private static ChannelRepository channelRepository; // Singleton instance of ChannelRepository

    /**
     * Returns a singleton instance of the ChannelRepositoryImp class.
     * @return The singleton instance of ChannelRepositoryImp.
     */
    public static ChannelRepository getInstance() {
        if(Objects.isNull(channelRepository))
            channelRepository  = new ChannelRepositoryImp();
        return channelRepository;
    }

    /**
     * Constructs a new ChannelRepositoryImp object and initializes the list of channels from the file.
     */
    private ChannelRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a new channel to the repository.
     * @param channel The channel to add.
     * @return true if the channel is added successfully, false otherwise.
     */
    @Override
    public boolean add(Channel channel) {
        boolean b = list.stream().anyMatch(ch -> Objects.equals(ch.getName(), channel.getName()));
        if(b) return false;
        list.add(channel);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a channel from the repository.
     * @param id The ID of the channel to delete.
     * @return true if the channel is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((channel) -> Objects.equals(channel.getId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates an existing channel in the repository.
     * @param channel The updated channel object.
     * @return true if the channel is updated successfully, false otherwise.
     */
    @Override
    public boolean update(Channel channel) {
        for (int i = 0; i < list.size(); i++) {
            Channel ch = list.get(i);
            if (Objects.equals(ch.getId(), channel.getId())) {
                list.set(i, channel);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all channels from the repository.
     * @return A list of all channels in the repository.
     */
    @Override
    public List<Channel> getAll() {
        return list;
    }

    /**
     * Retrieves a channel from the repository by its ID.
     * @param id The ID of the channel to retrieve.
     * @return The channel with the specified ID, or null if not found.
     */
    @Override
    public Channel get(String id) {
        return list.stream().filter((ch)->Objects.equals(ch.getId(),id))
                .findFirst().orElse(null);
    }

    /**
     * Finds channels with the specified name.
     * @param name The name of the channel to search for.
     * @return A list of channels with the specified name.
     */
    @Override
    public List<Channel> findWithName(String name) {
        return list.stream().filter((c)->c.getName().toLowerCase().contains(name.toLowerCase())
                        &&Objects.equals(c.getType(), ChannelType.PUBLIC))
                .collect(Collectors.toList());
    }
}
