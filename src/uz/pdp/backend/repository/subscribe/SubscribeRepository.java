package uz.pdp.backend.repository.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface SubscribeRepository extends BaseRepository<Subscribe> {
    List<Subscribe> getUserSubscribes(String id);

    List<Subscribe> fetchChannelMembers(String id);

    List<Subscribe> fetchChannelUser(String id);
}
