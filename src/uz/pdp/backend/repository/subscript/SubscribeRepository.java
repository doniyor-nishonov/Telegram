package uz.pdp.backend.repository.subscript;

import uz.pdp.backend.model.subscribe.Subscribe;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface SubscribeRepository extends BaseRepository<Subscribe> {
    List<Subscribe> getUserSubscribes(String id);
}
