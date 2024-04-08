package uz.pdp.backend.repository.subscript;

import uz.pdp.backend.model.subscript.Subscript;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SubscriptRepositoryImp implements SubscriptRepository{
    private List<Subscript> list;

    public SubscriptRepositoryImp() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Subscript subscript) {
         if (list.stream().anyMatch((s) -> Objects.equals(s.getChannelId(), subscript.getChannelId())
                && Objects.equals(s.getUserId(), subscript.getUserId())))
             return false;
         list.add(subscript);
         return true;

    }

    @Override
    public boolean delete(String id) {
        return list.removeIf((s)->Objects.equals(s.getId(),id));
    }

    @Override
    public boolean update(String id, Subscript newE) {
        int index = list.indexOf(get(id));
        if (index != -1) {
            list.set(index, newE);
            return true;
        }
        return false;
    }

    @Override
    public List<Subscript> getAll() {
        return list;
    }

    @Override
    public Subscript get(String id) {
        return list.stream().filter((s)->Objects.equals(s.getId(),id))
                .findFirst().orElse(null);
    }
}
