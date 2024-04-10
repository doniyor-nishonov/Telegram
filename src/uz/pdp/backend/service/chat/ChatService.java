package uz.pdp.backend.service.chat;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.service.BaseService;

import java.util.List;

public interface ChatService extends BaseService<Chat> {

    List<Chat> getUsersAllChats(String id1, String id2);

    List<Chat> getMyChats(String id, String id1);
}
