package uz.pdp.backend.service.channel;

import uz.pdp.backend.model.channel.Channel;
import uz.pdp.backend.repository.channel.ChannelRepository;
import uz.pdp.backend.repository.channel.ChannelRepositoryImp;

import java.util.List;
import java.util.Objects;

public class ChannelServiceImp implements ChannelService{
    private final ChannelRepository channelRepository = ChannelRepositoryImp.getInstance();
    private static ChannelService channelService;

    public static ChannelService getInstance() {
        if(Objects.isNull(channelService))
            channelService = new ChannelServiceImp();
        return channelService;
    }
    private ChannelServiceImp() {
    }
    @Override
    public List<Channel> getChannelByUser(String userId) {
        return channelRepository.getChannelByUser(userId);
    }
    @Override
    public boolean add(Channel channel) {
        return channelRepository.add(channel);
    }

    @Override
    public boolean delete(String id) {
        return channelRepository.delete(id);
    }

    @Override
    public boolean update(String id, Channel newE) {
        return channelRepository.update(id, newE);
    }

    @Override
    public List<Channel> getAll() {
        return channelRepository.getAll();
    }

    @Override
    public Channel get(String id) {
        return channelRepository.get(id);
    }

    @Override
    public List<Channel> findWithName(String name) {
        return channelRepository.findWithName(name);
    }
}
