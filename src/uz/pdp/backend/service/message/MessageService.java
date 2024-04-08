package uz.pdp.backend.service.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface MessageService extends BaseService<Message> {
    List<Message> getMessageAll(List<Chat> chats);
}