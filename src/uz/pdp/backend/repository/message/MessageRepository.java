package uz.pdp.backend.repository.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface MessageRepository extends BaseRepository<Message> {
    List<Message> getMessageAll(Chat chat,String id);

    List<Message> getMyMessage(Chat chat);

    List<Message> getGroupMessage(String chatId,String groupId);

    List<Message> getByGroupMyMessages(String chatId, String groupId);
}
