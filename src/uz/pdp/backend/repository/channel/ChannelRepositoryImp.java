package uz.pdp.backend.repository.channel;

import uz.pdp.backend.model.channel.Channel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ChannelRepositoryImp implements ChannelRepository{
    private List<Channel> list;

    public ChannelRepositoryImp() {
        this.list = new ArrayList<>();
    }

    @Override
    public List<Channel> getChannelByUser(String userId) {
        return list.stream()
                .filter((channel)-> Objects.equals(channel.getUserId(),userId))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Channel channel) {
        //anyMatch listni forda aylanib ifda tekshirib chiqadi va true qiymatt chiqganda to'xtaydi
        boolean b = list.stream().anyMatch(ch -> Objects.equals(ch.getName(), channel.getName()));
        if(b) return false;
        list.add(channel);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return list.removeIf((channel)-> Objects.equals(channel.getId(),id));
    }

    @Override
    public boolean update(String id, Channel newChannel) {
        for (int i = 0; i < list.size(); i++) {
            Channel ch = list.get(i);
            if (Objects.equals(ch.getId(), id)) {
                list.set(i, newChannel);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Channel> getAll() {
        return list;
    }

    @Override
    public Channel get(String id) {
        return list.stream().filter((ch)->Objects.equals(ch.getId(),id))
                .findFirst().orElse(null);
    }
}
