package uz.pdp.backend.repository.chat;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

public interface ChatRepository extends BaseRepository<Chat> {
    List<Chat> getUsersAllChats(String id1, String id2);

}
