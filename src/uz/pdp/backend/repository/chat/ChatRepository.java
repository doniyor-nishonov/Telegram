package uz.pdp.backend.repository.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

/**
 * The ChatRepository interface provides methods for accessing and managing chat data in the database.
 * It extends the BaseRepository interface.
 */
public interface ChatRepository extends BaseRepository<Chat> {

    /**
     * Retrieves a list of chat IDs associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of chat IDs associated with the user.
     */
    List<String> getUserChats(String id);

    /**
     * Finds or creates a chat with the specified IDs and message type.
     * @param id The ID of the first user.
     * @param id1 The ID of the second user.
     * @param type The type of the message (CHAT or GROUP).
     * @return The found or created chat object.
     */
    Chat findOrCreate(String id, String id1, MessageType type);
}
