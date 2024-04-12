package uz.pdp.backend.service.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface PostService extends BaseService<Post> {
    List<Post> getPostChannels(String channelId);
}
