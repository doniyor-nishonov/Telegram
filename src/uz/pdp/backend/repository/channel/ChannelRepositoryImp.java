package uz.pdp.backend.repository.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.channel.Channel;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChannelRepositoryImp implements ChannelRepository{
    private final List<Channel> list;
    private final String filePath = "db/channels.txt";
    private final ObjectWriterReader<Channel> owr = new ObjectWriterReader<>(filePath);
    private static ChannelRepository channelRepository;

    public static ChannelRepository getInstance() {
        if(Objects.isNull(channelRepository))
            channelRepository  = new ChannelRepositoryImp();
        return channelRepository;
    }
    private ChannelRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public List<Channel> getChannelByUser(String userId) {
        return list.stream()
                .filter((channel)-> Objects.equals(channel.getOwnerId(),userId))
                .collect(Collectors.toList());
    }

    @Override
    public boolean add(Channel channel) {
        //anyMatch listni forda aylanib ifda tekshirib chiqadi va true qiymat chiqganda to'xtaydi
        boolean b = list.stream().anyMatch(ch -> Objects.equals(ch.getName(), channel.getName()));
        if(b) return false;
        list.add(channel);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((channel) -> Objects.equals(channel.getId(), id));
        if(removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(Channel channel) {
        for (int i = 0; i < list.size(); i++) {
            Channel ch = list.get(i);
            if (Objects.equals(ch.getId(), channel.getId())) {
                list.set(i, channel);
                owr.writeObjects(list);
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

    @Override
    public List<Channel> findWithName(String name) {
        return list.stream().filter((c)->c.getName().toLowerCase().contains(name.toLowerCase())
                &&Objects.equals(c.getType(), ChannelType.PUBLIC))
                .collect(Collectors.toList());
    }
}
