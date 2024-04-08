package uz.pdp.backend.repository.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageRepositoryImp implements MessageRepository{
    private List<Message> list;

    public MessageRepositoryImp() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Message message) {
        if (message==null)
            return false;
        list.add(message);
        return true;
    }

    @Override
    public boolean delete(String id) {
        return list.removeIf((m)-> Objects.equals(m.getId(),id));
    }

    @Override
    public boolean update(String id, Message newE) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), id)) {
                list.set(i, newE);
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
    public List<Message> getMessageAll(List<Chat> chats) {
        List<Message> messages = new ArrayList<>();
        for (Message message : list)
            for (Chat chat : chats)
                if(Objects.equals(message.getChatId(),chat.getId()))
                    messages.add(message);
        return messages;
    }

    @Override
    public Message get(String id) {
        return list.stream().filter((m)->Objects.equals(m.getId(),id))
                .findFirst().orElse(null);

    }
}
