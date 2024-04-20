package uz.pdp.backend.repository.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.repository.BaseRepository;

import java.util.List;

/**
 * The MessageRepository interface provides methods for accessing and managing message data in the database.
 * It extends the BaseRepository interface.
 */
public interface MessageRepository extends BaseRepository<Message> {

    /**
     * Retrieves all messages in a chat where the user is either the sender or receiver.
     * @param chat The chat for which messages are retrieved.
     * @param id The ID of the user.
     * @return A list of all messages in the chat where the user is either the sender or receiver.
     */
    List<Message> getMessageAll(Chat chat, String id);

    /**
     * Retrieves all messages sent or received by the user in a chat.
     * @param chat The chat for which messages are retrieved.
     * @return A list of all messages sent or received by the user in the chat.
     */
    List<Message> getMyMessage(Chat chat);

    /**
     * Retrieves all messages sent in a group chat.
     * @param chatId The ID of the chat.
     * @param groupId The ID of the group.
     * @return A list of all messages sent in the group chat.
     */
    List<Message> getGroupMessage(String chatId, String groupId);

    /**
     * Retrieves all messages sent by the user in a group chat.
     * @param chatId The ID of the chat.
     * @param groupId The ID of the group.
     * @return A list of all messages sent by the user in the group chat.
     */
    List<Message> getByGroupMyMessages(String chatId, String groupId);
}
