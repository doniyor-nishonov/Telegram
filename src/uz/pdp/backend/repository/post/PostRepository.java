package uz.pdp.backend.repository.post;

import uz.pdp.backend.model.post.Post;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface PostRepository extends BaseRepository<Post> {
    List<Post> getPostChannels(String channelId);
}
