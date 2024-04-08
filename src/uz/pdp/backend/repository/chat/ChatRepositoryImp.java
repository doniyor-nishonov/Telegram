package uz.pdp.backend.repository.chat;

import uz.pdp.backend.model.chat.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChatRepositoryImp implements ChatRepository {
    private List<Chat> list;

    public ChatRepositoryImp() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Chat chat) {
        if(chat==null)
            return false;
        list.add(chat);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return list.removeIf(chat -> chat.getId().equals(id));
    }

    @Override
    public boolean update(String id, Chat newChat) {
        for (int i = 0; i < list.size(); i++) {
            var ch = list.get(i);
            if(Objects.equals(ch.getUserId2(),id)){
                list.set(i, newChat);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Chat> getAll() {
        return list;
    }

    @Override
    public Chat get(String id) {
        return list.stream().filter((chat)->Objects.equals(chat.getId(),id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Chat> getUsersAllChats(String id1, String id2) {
        for (Chat chat : list) {
            if(Objects.equals(chat.getUserId2(),id1))
                chat.setState(true);
        }
        return list.stream().filter((ch)->Objects.equals(ch.getUserId1(),id1)&&Objects.equals(ch.getUserId2(),id2)
                || Objects.equals(ch.getUserId1(),id2)&&Objects.equals(ch.getUserId2(),id1))
                .collect(Collectors.toList());
    }
}
