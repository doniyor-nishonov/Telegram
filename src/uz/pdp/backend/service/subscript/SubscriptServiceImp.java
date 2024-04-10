package uz.pdp.backend.service.subscript;

import uz.pdp.backend.model.subscript.Subscribe;
import uz.pdp.backend.repository.subscript.SubscribeRepository;
import uz.pdp.backend.repository.subscript.SubscribeRepositoryImp;

import java.util.List;
import java.util.Objects;

public class SubscriptServiceImp implements SubscriptService {
    private final SubscribeRepository subscribeRepository = SubscribeRepositoryImp.getInstance();
    private static SubscriptService subscriptService;
    private SubscriptServiceImp() {
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
    public boolean update(String id, Subscribe newE) {
        return subscribeRepository.update(id, newE);
    }

    @Override
    public List<Subscribe> getAll() {
        return subscribeRepository.getAll();
    }

    @Override
    public  Subscribe get(String id) {
        return subscribeRepository.get(id);
    }
    public static SubscriptService getInstance(){
        if(Objects.isNull(subscriptService)){
            subscriptService = new SubscriptServiceImp();
        }
        return subscriptService;
    }
}
