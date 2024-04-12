package uz.pdp.backend.repository.subscript;

import uz.pdp.backend.model.subscript.Subscribe;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;
import java.util.Map;

public interface SubscribeRepository extends BaseRepository<Subscribe> {
    List<Subscribe> getUserSubscribes(String id);
}
