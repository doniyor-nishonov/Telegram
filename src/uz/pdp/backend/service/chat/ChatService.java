package uz.pdp.backend.service.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.service.BaseService;

import java.util.List;
/**
 * The ChatService interface provides methods to perform operations related to chats.
 * It extends the BaseService interface, which provides basic CRUD operations.
 */

public interface ChatService extends BaseService<Chat> {

    /**
     * Retrieves a list of chat IDs associated with a specific user.
     *
     * @param id the ID of the user whose chats are to be retrieved
     * @return a list of chat IDs associated with the specified user
     */
    List<String> getUserChats(String id);

    /**
     * Finds or creates a chat between two users with a specified message type.
     *
     * @param id   the ID of one user
     * @param id1  the ID of the other user
     * @param type the type of message exchanged in the chat
     * @return the chat between the two users, creating a new one if it doesn't exist
     */
    Chat findOrCreate(String id, String id1, MessageType type);
}
