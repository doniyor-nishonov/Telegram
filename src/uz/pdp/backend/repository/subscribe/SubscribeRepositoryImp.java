
package uz.pdp.backend.repository.subscribe;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.subscribe.Subscribe;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * The SubscribeRepositoryImp class implements the SubscribeRepository interface
 * and provides methods to perform CRUD operations on Subscribe objects.
 */
public class SubscribeRepositoryImp implements SubscribeRepository {

    private final List<Subscribe> list;
    private final String filePath = "db/subscribes.txt";
    private final ListFileHandler<Subscribe> owr = new ListFileHandler<>(filePath);
    private static SubscribeRepository subscribeRepository;

    /**
     * Returns a singleton instance of SubscribeRepositoryImp.
     *
     * @return The singleton instance of SubscribeRepositoryImp
     */
    public static SubscribeRepository getInstance() {
        if (Objects.isNull(subscribeRepository))
            subscribeRepository = new SubscribeRepositoryImp();
        return subscribeRepository;
    }

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of subscribes by reading from file.
     */
    private SubscribeRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a subscription to the repository.
     *
     * @param subscribe The subscription to add
     * @return true if the subscription was added successfully, false otherwise
     */
    @Override
    public boolean add(Subscribe subscribe) {
        if (list.stream().anyMatch((s) -> Objects.equals(s.getChannelId(), subscribe.getChannelId())
                && Objects.equals(s.getUserId(), subscribe.getUserId())))
            return false;
        list.add(subscribe);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a subscription from the repository based on its ID.
     *
     * @param id The ID of the subscription to delete
     * @return true if the subscription was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((s) -> Objects.equals(s.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates a subscription in the repository.
     *
     * @param subscribe The updated subscription
     * @return true if the subscription was updated successfully, false otherwise
     */
    @Override
    public boolean update(Subscribe subscribe) {
        int index = list.indexOf(get(subscribe.getId()));
        if (index != -1) {
            list.set(index, subscribe);
            owr.writeObjects(list);
            return true;
        }
        return false;
    }

    /**
     * Retrieves all subscriptions from the repository.
     *
     * @return A list of all subscriptions
     */
    @Override
    public List<Subscribe> getAll() {
        return list;
    }

    /**
     * Retrieves a subscription from the repository based on its ID.
     *
     * @param id The ID of the subscription to retrieve
     * @return The subscription with the provided ID, or null if not found
     */
    @Override
    public Subscribe get(String id) {
        return list.stream().filter((s) -> Objects.equals(s.getId(), id))
                .findFirst().orElse(null);
    }

    /**
     * Retrieves all subscriptions of a user.
     *
     * @param userId The ID of the user
     * @return A list of subscriptions associated with the provided user ID
     */
    @Override
    public List<Subscribe> getUserSubscribes(String userId) {
        return list.stream()
                .filter(s -> !Objects.equals(s.getRole(), Role.BLOCK) && Objects.equals(s.getUserId(), userId))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all members of a channel.
     *
     * @param id The ID of the channel
     * @return A list of subscriptions associated with the provided channel ID
     */
    @Override
    public List<Subscribe> fetchChannelMembers(String id) {
        return list.stream().filter(s -> Objects.equals(s.getChannelId(), id))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all channels subscribed by a user with admin role.
     *
     * @param id The ID of the user
     * @return A list of subscriptions associated with the provided user ID and admin role
     */
    @Override
    public List<Subscribe> fetchChannelUser(String id) {
        return list.stream().filter(s -> Objects.equals(s.getRole(), Role.ADMIN) && Objects.equals(s.getUserId(), id))
                .collect(Collectors.toList());
    }
}
