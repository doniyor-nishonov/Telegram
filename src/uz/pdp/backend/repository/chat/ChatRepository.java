package uz.pdp.backend.repository.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface ChatRepository extends BaseRepository<Chat> {

    List<String> getUserChats(String id);

    Chat findOrCreate(String id, String id1, MessageType type);
}
