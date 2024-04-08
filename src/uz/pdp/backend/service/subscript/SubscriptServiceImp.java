package uz.pdp.backend.service.subscript;

import uz.pdp.backend.model.subscript.Subscript;
import uz.pdp.backend.repository.subscript.SubscriptRepository;
import uz.pdp.backend.repository.subscript.SubscriptRepositoryImp;

import java.util.List;

public class SubscriptServiceImp implements SubscriptService {
    private final SubscriptRepository subscriptRepository = new SubscriptRepositoryImp();
    @Override
    public boolean add(Subscript subscript) {
        return subscriptRepository.add(subscript);
    }

    @Override
    public boolean delete(String id) {
        return subscriptRepository.delete(id);
    }

    @Override
    public boolean update(String id, Subscript newE) {
        return subscriptRepository.update(id, newE);
    }

    @Override
    public List<Subscript> getAll() {
        return subscriptRepository.getAll();
    }

    @Override
    public Subscript get(String id) {
        return subscriptRepository.get(id);
    }
}
