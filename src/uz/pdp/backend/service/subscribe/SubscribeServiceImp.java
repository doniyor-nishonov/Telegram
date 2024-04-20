package uz.pdp.backend.service.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.repository.subscribe.SubscribeRepository;
import uz.pdp.backend.repository.subscribe.SubscribeRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the SubscribeService interface.
 * This class provides methods to interact with Subscribe entities.
 */
public class SubscribeServiceImp implements SubscribeService {

    private final SubscribeRepository subscribeRepository = SubscribeRepositoryImp.getInstance();
    private static SubscribeService subscribeService;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private SubscribeServiceImp() {
    }

    /**
     * Returns a singleton instance of SubscribeService.
     *
     * @return the instance of SubscribeService
     */
    public static SubscribeService getInstance() {
        if (Objects.isNull(subscribeService)) {
            subscribeService = new SubscribeServiceImp();
        }
        return subscribeService;
    }

    /**
     * Adds a new subscription to the repository.
     *
     * @param subscribe the subscription to be added
     * @return true if the subscription is successfully added, false otherwise
     */
    @Override
    public boolean add(Subscribe subscribe) {
        return subscribeRepository.add(subscribe);
    }

    /**
     * Deletes a subscription from the repository by its ID.
     *
     * @param id the ID of the subscription to be deleted
     * @return true if the subscription is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return subscribeRepository.delete(id);
    }

    /**
     * Updates an existing subscription in the repository.
     *
     * @param newE the updated subscription object
     * @return true if the subscription is successfully updated, false otherwise
     */
    @Override
    public boolean update(Subscribe newE) {
        return subscribeRepository.update(newE);
    }

    /**
     * Retrieves all subscriptions from the repository.
     *
     * @return a list of all subscriptions
     */
    @Override
    public List<Subscribe> getAll() {
        return subscribeRepository.getAll();
    }

    /**
     * Retrieves a subscription from the repository by its ID.
     *
     * @param id the ID of the subscription to retrieve
     * @return the subscription object if found, null otherwise
     */
    @Override
    public Subscribe get(String id) {
        return subscribeRepository.get(id);
    }

    /**
     * Retrieves all subscriptions of a user.
     *
     * @param id the ID of the user
     * @return a list of subscriptions of the user
     */
    @Override
    public List<Subscribe> getUserSubscribes(String id) {
        return subscribeRepository.getUserSubscribes(id);
    }

    /**
     * Retrieves all members of a channel.
     *
     * @param id the ID of the channel
     * @return a list of members of the channel
     */
    @Override
    public List<Subscribe> fetchChannelMembers(String id) {
        return subscribeRepository.fetchChannelMembers(id);
    }

    /**
     * Retrieves all users subscribed to a channel.
     *
     * @param id the ID of the channel
     * @return a list of users subscribed to the channel
     */
    @Override
    public List<Subscribe> fetchChannelUser(String id) {
        return subscribeRepository.fetchChannelUser(id);
    }
}
