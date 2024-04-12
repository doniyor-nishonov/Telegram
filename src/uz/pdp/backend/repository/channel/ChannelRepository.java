package uz.pdp.backend.repository.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface ChannelRepository extends BaseRepository<Channel> {
    List<Channel> getChannelByUser(String userId);

    List<Channel> findWithName(String name);
}
