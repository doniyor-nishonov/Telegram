package uz.pdp.backend.service.message;

import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.repository.message.MessageRepository;
import uz.pdp.backend.repository.message.MessageRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * Implementation of the MessageService interface.
 * This class provides methods to interact with Message entities.
 */
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository = MessageRepositoryImp.getInstance();
    private static MessageService messageService;

    /**
     * Private constructor to prevent direct instantiation.
     */
    private MessageServiceImp() {
    }

    /**
     * Returns a singleton instance of MessageService.
     *
     * @return the instance of MessageService
     */
    public static MessageService getInstance() {
        if (Objects.isNull(messageService))
            messageService = new MessageServiceImp();
        return messageService;
    }

    /**
     * Adds a new message to the repository.
     *
     * @param message the message to be added
     * @return true if the message is successfully added, false otherwise
     */
    @Override
    public boolean add(Message message) {
        return messageRepository.add(message);
    }

    /**
     * Deletes a message from the repository by its ID.
     *
     * @param id the ID of the message to be deleted
     * @return true if the message is successfully deleted, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return messageRepository.delete(id);
    }

    /**
     * Updates an existing message in the repository.
     *
     * @param newE the updated message object
     * @return true if the message is successfully updated, false otherwise
     */
    @Override
    public boolean update(Message newE) {
        return messageRepository.update(newE);
    }

    /**
     * Retrieves all messages in a chat by chat ID and user ID.
     *
     * @param chat the chat for which messages are to be retrieved
     * @param id   the ID of the user
     * @return a list of messages in the chat
     */
    @Override
    public List<Message> getMessageAll(Chat chat, String id) {
        return messageRepository.getMessageAll(chat, id);
    }

    /**
     * Retrieves all messages sent by the current user in a chat.
     *
     * @param chat the chat for which messages are to be retrieved
     * @return a list of messages sent by the current user in the chat
     */
    @Override
    public List<Message> getMyMessage(Chat chat) {
        return messageRepository.getMyMessage(chat);
    }

    /**
     * Retrieves all messages sent to a group in a chat.
     *
     * @param chatId  the ID of the chat
     * @param groupId the ID of the group
     * @return a list of messages sent to the group in the chat
     */
    @Override
    public List<Message> getGroupMessage(String chatId, String groupId) {
        return messageRepository.getGroupMessage(chatId, groupId);
    }

    /**
     * Retrieves all messages sent by the current user to a specific group in a chat.
     *
     * @param chatId  the ID of the chat
     * @param groupId the ID of the group
     * @return a list of messages sent by the current user to the group in the chat
     */
    @Override
    public List<Message> getByGroupMyMessages(String chatId, String groupId) {
        return messageRepository.getByGroupMyMessages(chatId, groupId);
    }

    /**
     * Retrieves all messages from the repository.
     *
     * @return a list of all messages
     */
    @Override
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    /**
     * Retrieves a message from the repository by its ID.
     *
     * @param id the ID of the message to retrieve
     * @return the message object if found, null otherwise
     */
    @Override
    public Message get(String id) {
        return messageRepository.get(id);
    }
}
