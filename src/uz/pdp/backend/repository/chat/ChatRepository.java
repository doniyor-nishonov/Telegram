package uz.pdp.backend.repository.chat;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;
import java.util.Set;

public interface ChatRepository extends BaseRepository<Chat> {
    List<Chat> getUsersAllChats(String id1, String id2);

    List<Chat> getMyChats(String id, String id1);

    Set<String> getUserChats(String id);

    Chat findOrCreate(String id, String id1);
}
