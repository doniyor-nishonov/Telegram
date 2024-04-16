package uz.pdp.backend.repository.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.chat.Chat;


import java.util.*;

public class ChatRepositoryImp implements ChatRepository {
    private final List<Chat> list;

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
    public boolean update(Chat chat) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), chat.getId())) {
                list.set(i, chat);
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
    public List<String> getUserChats(String id) {
        List<String> chats = new ArrayList<>();
        for (Chat chat : list) {
            if (chat.getType() == MessageType.CHAT &&
                    (Objects.equals(chat.getId1(), id) || Objects.equals(chat.getId2(), id))) {
                chats.add(Objects.equals(chat.getId1(), id) ? chat.getId2() : chat.getId1());
            }
        }
        return chats;
    }


    @Override
    public Chat findOrCreate(String id, String id1, MessageType type) {
        return list.stream().filter((c) -> (Objects.equals(c.getId1(), id) && Objects.equals(c.getId2(), id1))
                        || (Objects.equals(c.getId2(), id) && Objects.equals(c.getId1(), id1)))
                .findFirst().orElseGet(() -> {
                    Chat chat = new Chat(id, id1,type);
                    list.add(chat);
                    owr.writeObjects(list);
                    return chat;
                });
    }
}
