
package uz.pdp.backend.repository.message;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.model.message.Message;
import uz.pdp.backend.nio.path.ChildPath;
import uz.pdp.backend.nio.path.DirectoryPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
/**
 * This class implements the MessageRepository interface and provides methods
 * to perform CRUD operations on Message objects.
 */
public class MessageRepositoryImp implements MessageRepository {

    private final List<Message> list;
    private final ListFileHandler<Message> owr = new ListFileHandler<>(DirectoryPath.DB, ChildPath.MESSAGE);
    private static MessageRepository messageRepository;

    /**
     * Private constructor to prevent direct instantiation.
     * Initializes the list of messages by reading from file.
     */
    private MessageRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Returns a singleton instance of MessageRepositoryImp.
     *
     * @return The singleton instance of MessageRepositoryImp
     */
    public static MessageRepository getInstance() {
        if (Objects.isNull(messageRepository))
            messageRepository = new MessageRepositoryImp();
        return messageRepository;
    }

    /**
     * Adds a message to the repository.
     *
     * @param message The message to add
     * @return true if the message was added successfully, false otherwise
     */
    @Override
    public boolean add(Message message) {
        if (Objects.isNull(message))
            return false;
        list.add(message);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a message from the repository based on its ID.
     *
     * @param id The ID of the message to delete
     * @return true if the message was deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf((m) -> Objects.equals(m.getId(), id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates a message in the repository.
     *
     * @param message The updated message
     * @return true if the message was updated successfully, false otherwise
     */
    @Override
    public boolean update(Message message) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), message.getId())) {
                list.set(i, message);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all messages from the repository.
     *
     * @return A list of all messages
     */
    @Override
    public List<Message> getAll() {
        return list;
    }

    /**
     * Retrieves all messages associated with a specific chat and sender.
     * If the sender's ID matches the provided ID, sets the state of the message to true.
     *
     * @param chat The chat for which messages are to be retrieved
     * @param id   The ID of the sender
     * @return A list of messages associated with the provided chat and sender
     */
    @Override
    public List<Message> getMessageAll(Chat chat, String id) {
        List<Message> messages = new ArrayList<>();
        for (Message message : list) {
            if (Objects.equals(message.getChatId(), chat.getId()) && Objects.equals(MessageType.CHAT, message.getType())) {
                if (Objects.equals(message.getSenderId(), id))
                    message.setState(true);
                messages.add(message);
            }
        }
        owr.writeObjects(list);
        return messages;
    }

    /**
     * Retrieves a message from the repository based on its ID.
     *
     * @param id The ID of the message to retrieve
     * @return The message with the provided ID, or null if not found
     */
    @Override
    public Message get(String id) {
        return list.stream().filter((m) -> Objects.equals(m.getId(), id))
                .findFirst().orElse(null);
    }

    /**
     * Retrieves all messages sent by the user in a specific chat.
     *
     * @param chat The chat for which messages are to be retrieved
     * @return A list of messages sent by the user in the provided chat
     */
    @Override
    public List<Message> getMyMessage(Chat chat) {
        List<Message> messages = new ArrayList<>();
        for (Message message : list) {
            if (Objects.equals(message.getChatId(), chat.getId())
                    && Objects.equals(chat.getId2(), message.getSenderId())
                    && Objects.equals(MessageType.CHAT, message.getType())) {
                messages.add(message);
            }
        }
        return messages;
    }

    /**
     * Retrieves all group messages sent to a specific chat except those sent by the chat itself.
     *
     * @param chatId  The ID of the chat
     * @param groupId The ID of the sender group
     * @return A list of group messages sent to the chat except those sent by the chat itself
     */
    @Override
    public List<Message> getGroupMessage(String chatId, String groupId) {
        List<Message> messages = new ArrayList<>();
        for (Message message : list) {
            if (Objects.equals(message.getSenderId(), groupId) && Objects.equals(MessageType.GROUP, message.getType())) {
                if (!Objects.equals(message.getChatId(), chatId))
                    message.setState(true);
                messages.add(message);
            }
        }
        owr.writeObjects(list);
        return messages;
    }

    /**
     * Retrieves all group messages sent by the user in a specific chat.
     *
     * @param chatId  The ID of the chat
     * @param groupId The ID of the sender group
     * @return A list of group messages sent by the user in the provided chat
     */
    @Override
    public List<Message> getByGroupMyMessages(String chatId, String groupId) {
        return list.stream().filter(message -> Objects.equals(message.getSenderId(), groupId)
                        && Objects.equals(message.getChatId(), chatId)
                        && Objects.equals(MessageType.GROUP, message.getType()))
                .collect(Collectors.toList());
    }
}
