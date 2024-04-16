package uz.pdp.backend.service.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface SubscribeService extends BaseService<Subscribe> {
    List<Subscribe> getUserSubscribes(String id);

    List<Subscribe> fetchChannelMembers(String id);

    List<Subscribe> fetchChannelUser(String id);

}
