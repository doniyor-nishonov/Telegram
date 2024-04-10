package uz.pdp.backend.repository.chat;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.chat.Chat;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ChatRepositoryImp implements ChatRepository {
    private List<Chat> list;

    private final String filePath = "db/chats.txt";
    private final ObjectWriterReader<Chat> owr = new ObjectWriterReader<>(filePath);
    private static ChatRepository chatRepository;

    public static ChatRepository getInstance() {
        if (Objects.isNull(chatRepository))
            chatRepository = new ChatRepositoryImp();
        return chatRepository;
    }

    private ChatRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public boolean add(Chat chat) {
        if (Objects.isNull(chat))
            return false;
        list.add(chat);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf(chat -> chat.getId().equals(id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, Chat newChat) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId2(), id)) {
                list.set(i, newChat);
                owr.writeObjects(list);
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
        return list.stream().filter((chat) -> Objects.equals(chat.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Chat> getUsersAllChats(String id1, String id2) {
        return list.stream().filter((ch) -> Objects.equals(ch.getId1(), id1) && Objects.equals(ch.getId2(), id2)
                        || Objects.equals(ch.getId1(), id2) && Objects.equals(ch.getId2(), id1))
                .collect(Collectors.toList());
    }

    @Override
    public List<Chat> getMyChats(String id, String id1) {
        return list.stream().filter((c) -> Objects.equals(c.getId1(), id) && Objects.equals(c.getId2(), id1))
                .collect(Collectors.toList());
    }
}
