package uz.pdp.backend.service.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.service.BaseService;

import java.util.List;

/**
 * Service interface for managing Message entities.
 * Extends the BaseService interface.
 */
public interface MessageService extends BaseService<Message> {

    /**
     * Retrieves all messages in a chat by chat ID and user ID.
     *
     * @param chat the chat for which messages are to be retrieved
     * @param id   the ID of the user
     * @return a list of messages in the chat
     */
    List<Message> getMessageAll(Chat chat, String id);

    /**
     * Retrieves all messages sent by the current user in a chat.
     *
     * @param chat the chat for which messages are to be retrieved
     * @return a list of messages sent by the current user in the chat
     */
    List<Message> getMyMessage(Chat chat);

    /**
     * Retrieves all messages sent to a group in a chat.
     *
     * @param chatId  the ID of the chat
     * @param groupId the ID of the group
     * @return a list of messages sent to the group in the chat
     */
    List<Message> getGroupMessage(String chatId, String groupId);

    /**
     * Retrieves all messages sent by the current user to a specific group in a chat.
     *
     * @param chatId  the ID of the chat
     * @param groupId the ID of the group
     * @return a list of messages sent by the current user to the group in the chat
     */
    List<Message> getByGroupMyMessages(String chatId, String groupId);
}
