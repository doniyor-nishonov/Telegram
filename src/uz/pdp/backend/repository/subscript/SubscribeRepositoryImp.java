package uz.pdp.backend.repository.subscript;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.subscript.Subscribe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubscribeRepositoryImp implements SubscribeRepository {
    private final List<Subscribe> list;
    private final String filePath = "db/subscribes.txt";
    private final ObjectWriterReader<Subscribe> owr = new ObjectWriterReader<>(filePath);
    private static SubscribeRepository subscribeRepository;

    public static SubscribeRepository getInstance() {
        if(Objects.isNull(subscribeRepository))
            subscribeRepository  = new SubscribeRepositoryImp();
        return subscribeRepository;
    }
    private SubscribeRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public boolean add(Subscribe subscribe) {
         if (list.stream().anyMatch((s) -> Objects.equals(s.getChannelId(), subscribe.getChannelId())
                && Objects.equals(s.getUserId(), subscribe.getUserId())))
             return false;
         list.add(subscribe);
         owr.writeObjects(list);
         return true;

    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((s) -> Objects.equals(s.getId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, Subscribe newE) {
        int index = list.indexOf(get(id));
        if (index != -1) {
            list.set(index, newE);
            owr.writeObjects(list);
            return true;
        }
        return false;
    }

    @Override
    public List<Subscribe> getAll() {
        return list;
    }

    @Override
    public Subscribe get(String id) {
        return list.stream().filter((s)->Objects.equals(s.getId(),id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Subscribe> getUserSubscribes(String userId) {
        return list.stream()
                .filter(s -> Objects.equals(s.getUserId(), userId))
                .collect(Collectors.toList());
    }
}
