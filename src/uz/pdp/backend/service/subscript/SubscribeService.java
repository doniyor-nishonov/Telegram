package uz.pdp.backend.service.subscript;

import uz.pdp.backend.model.subscript.Subscribe;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface SubscribeService extends BaseService<Subscribe> {
    List<Subscribe> getUserSubscribes(String id);
}
