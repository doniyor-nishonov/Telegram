package uz.pdp.backend.service.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface ChatService extends BaseService<Chat> {

    List<String> getUserChats(String id);

    Chat findOrCreate(String id, String id1, MessageType type);
}
