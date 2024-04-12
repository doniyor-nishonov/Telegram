package uz.pdp.backend.service.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface ChannelService extends BaseService<Channel> {
    List<Channel> getChannelByUser(String userId);

    List<Channel> findWithName(String name);
}
