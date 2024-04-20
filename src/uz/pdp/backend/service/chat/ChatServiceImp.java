package uz.pdp.backend.service.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.repository.chat.ChatRepository;
import uz.pdp.backend.repository.chat.ChatRepositoryImp;

import java.util.List;
import java.util.Objects;

/**
 * The ChatServiceImp class implements the ChatService interface and provides
 * functionality to perform operations on chats.
 */
public class ChatServiceImp implements ChatService {

    private final ChatRepository chatRepository = ChatRepositoryImp.getInstance();
    private static ChatService chatService;

    /**
     * Retrieves an instance of the ChatServiceImp class.
     *
     * @return an instance of the ChatServiceImp class
     */
    public static ChatService getInstance() {
        if (Objects.isNull(chatService))
            chatService = new ChatServiceImp();
        return chatService;
    }

    private ChatServiceImp() {
    }

    /**
     * Adds a new chat.
     *
     * @param chat the chat to add
     * @return true if the chat is added successfully, false otherwise
     */
    @Override
    public boolean add(Chat chat) {
        return chatRepository.add(chat);
    }

    /**
     * Deletes a chat by its ID.
     *
     * @param id the ID of the chat to delete
     * @return true if the chat is deleted successfully, false otherwise
     */
    @Override
    public boolean delete(String id) {
        return chatRepository.delete(id);
    }

    /**
     * Updates a chat.
     *
     * @param newE the updated chat
     * @return true if the chat is updated successfully, false otherwise
     */
    @Override
    public boolean update(Chat newE) {
        return chatRepository.update(newE);
    }

    /**
     * Retrieves all chats.
     *
     * @return a list of all chats
     */
    @Override
    public List<Chat> getAll() {
        return chatRepository.getAll();
    }

    /**
     * Retrieves a chat by its ID.
     *
     * @param id the ID of the chat to retrieve
     * @return the chat with the specified ID
     */
    @Override
    public Chat get(String id) {
        return chatRepository.get(id);
    }

    /**
     * Retrieves a list of chat IDs associated with a specific user.
     *
     * @param id the ID of the user whose chats are to be retrieved
     * @return a list of chat IDs associated with the specified user
     */
    @Override
    public List<String> getUserChats(String id) {
        return chatRepository.getUserChats(id);
    }

    /**
     * Finds or creates a chat between two users with a specified message type.
     *
     * @param id   the ID of one user
     * @param id1  the ID of the other user
     * @param type the type of message exchanged in the chat
     * @return the chat between the two users, creating a new one if it doesn't exist
     */
    @Override
    public Chat findOrCreate(String id, String id1, MessageType type) {
        return chatRepository.findOrCreate(id, id1, type);
    }
}
