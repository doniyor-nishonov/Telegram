package uz.pdp.backend.service.subscribe;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.repository.subscribe.SubscribeRepository;
import uz.pdp.backend.repository.subscribe.SubscribeRepositoryImp;

import java.util.List;
import java.util.Objects;

public class SubscribeServiceImp implements SubscribeService {
    private final SubscribeRepository subscribeRepository = SubscribeRepositoryImp.getInstance();
    private static SubscribeService subscribeService;
    private SubscribeServiceImp() {
    }
    public static SubscribeService getInstance(){
        if(Objects.isNull(subscribeService)){
            subscribeService = new SubscribeServiceImp();
        }
        return subscribeService;
    }
    @Override
    public boolean add(Subscribe subscribe) {
        return subscribeRepository.add(subscribe);
    }

    @Override
    public boolean delete(String id) {
        return subscribeRepository.delete(id);
    }

    @Override
    public boolean update(Subscribe newE) {
        return subscribeRepository.update(newE);
    }

    @Override
    public List<Subscribe> getAll() {
        return subscribeRepository.getAll();
    }

    @Override
    public  Subscribe get(String id) {
        return subscribeRepository.get(id);
    }

    @Override
    public List<Subscribe> getUserSubscribes(String id) {
        return subscribeRepository.getUserSubscribes(id);
    }

    @Override
    public List<Subscribe> fetchChannelMembers(String id) {
        return subscribeRepository.fetchChannelMembers(id);
    }

    @Override
    public List<Subscribe> fetchChannelUser(String id) {
        return subscribeRepository.fetchChannelUser(id);
    }
}
