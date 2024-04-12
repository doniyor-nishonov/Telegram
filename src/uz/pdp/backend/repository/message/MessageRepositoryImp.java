package uz.pdp.backend.repository.message;

import uz.pdp.backend.io.ObjectWriterReader;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageRepositoryImp implements MessageRepository {
    private final List<Message> list;
    private final String filePath = "db/message.txt";
    private final ObjectWriterReader<Message> owr = new ObjectWriterReader<>(filePath);
    private static MessageRepository messageRepository;

    public static MessageRepository getInstance() {
        if (Objects.isNull(messageRepository))
            messageRepository = new MessageRepositoryImp();
        return messageRepository;
    }

    private MessageRepositoryImp() {
        list = owr.readObjects();
    }

    @Override
    public boolean add(Message message) {
        if (Objects.isNull(message))
            return false;
        list.add(message);
        owr.writeObjects(list);
        return true;
    }

    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((m) -> Objects.equals(m.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    @Override
    public boolean update(String id, Message newE) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.set(i, newE);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Message> getAll() {
        return list;
    }

    @Override
    public List<Message> getMessageAll(List<Chat> chats, String userId) {
        List<Message> messages = new ArrayList<>();
        for (Chat chat : chats) {
            for (Message message : list) {
                if (Objects.equals(message.getChatId(), chat.getId())) {
                    if (Objects.equals(chat.getId2(), userId))
                        message.setState(true);
                    messages.add(message);
                }
            }
        }
        owr.writeObjects(list);
        return messages;
    }

    @Override
    public Message get(String id) {
        return list.stream().filter((m) -> Objects.equals(m.getId(), id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Message> getMyMessage(List<Chat> chats, String id) {
        List<Message> messages = new ArrayList<>();
        for (Message message : list) {
            String chatId = message.getChatId();
            for (Chat chat : chats) {
                if (Objects.equals(chatId, chat.getId()) && Objects.equals(chat.getId1(), id)) {
                    messages.add(message);
                }
            }
        }
        return messages;
    }
}
