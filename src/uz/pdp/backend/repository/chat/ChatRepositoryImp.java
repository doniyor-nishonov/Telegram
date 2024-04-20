package uz.pdp.backend.repository.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.nio.ListFileHandler;
import uz.pdp.backend.model.chat.Chat;
import uz.pdp.backend.nio.path.ChildPath;
import uz.pdp.backend.nio.path.DirectoryPath;

import java.util.*;

/**
 * The ChatRepositoryImp class implements the ChatRepository interface to provide methods for
 * accessing and managing chat data using file storage.
 */
public class ChatRepositoryImp implements ChatRepository {

    private final List<Chat> list; // The list of chats
    private final ListFileHandler<Chat> owr = new ListFileHandler<>(DirectoryPath.DB, ChildPath.CHATS); // The file handler for reading and writing chat data
    private static ChatRepository chatRepository; // Singleton instance of ChatRepository

    /**
     * Returns a singleton instance of the ChatRepositoryImp class.
     * @return The singleton instance of ChatRepositoryImp.
     */
    public static ChatRepository getInstance() {
        if (Objects.isNull(chatRepository))
            chatRepository = new ChatRepositoryImp();
        return chatRepository;
    }

    /**
     * Constructs a new ChatRepositoryImp object and initializes the list of chats from the file.
     */
    private ChatRepositoryImp() {
        list = owr.readObjects();
    }

    /**
     * Adds a new chat to the repository.
     * @param chat The chat to add.
     * @return true if the chat is added successfully, false otherwise.
     */
    @Override
    public boolean add(Chat chat) {
        if (Objects.isNull(chat))
            return false;
        list.add(chat);
        owr.writeObjects(list);
        return true;
    }

    /**
     * Deletes a chat from the repository.
     * @param id The ID of the chat to delete.
     * @return true if the chat is deleted successfully, false otherwise.
     */
    @Override
    public boolean delete(String id) {
        boolean removed = list.removeIf(chat -> chat.getId().equals(id));
        if (removed)
            owr.writeObjects(list);
        return removed;
    }

    /**
     * Updates an existing chat in the repository.
     * @param chat The updated chat object.
     * @return true if the chat is updated successfully, false otherwise.
     */
    @Override
    public boolean update(Chat chat) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(list.get(i).getId(), chat.getId())) {
                list.set(i, chat);
                owr.writeObjects(list);
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all chats from the repository.
     * @return A list of all chats in the repository.
     */
    @Override
    public List<Chat> getAll() {
        return list;
    }

    /**
     * Retrieves a chat from the repository by its ID.
     * @param id The ID of the chat to retrieve.
     * @return The chat with the specified ID, or null if not found.
     */
    @Override
    public Chat get(String id) {
        return list.stream().filter((chat) -> Objects.equals(chat.getId(), id))
                .findFirst().orElse(null);
    }

    /**
     * Retrieves a list of chat IDs associated with the specified user ID.
     * @param id The ID of the user.
     * @return A list of chat IDs associated with the user.
     */
    @Override
    public List<String> getUserChats(String id) {
        List<String> chats = new ArrayList<>();
        for (Chat chat : list) {
            if (chat.getType() == MessageType.CHAT &&
                    (Objects.equals(chat.getId1(), id) || Objects.equals(chat.getId2(), id))) {
                chats.add(Objects.equals(chat.getId1(), id) ? chat.getId2() : chat.getId1());
            }
        }
        return chats;
    }

    /**
     * Finds or creates a chat with the specified IDs and message type.
     * @param id The ID of the first user.
     * @param id1 The ID of the second user.
     * @param type The type of the message (CHAT or GROUP).
     * @return The found or created chat object.
     */
    @Override
    public Chat findOrCreate(String id, String id1, MessageType type) {
        return list.stream().filter((c) -> (Objects.equals(c.getId1(), id) && Objects.equals(c.getId2(), id1))
                        || (Objects.equals(c.getId2(), id) && Objects.equals(c.getId1(), id1)))
                .findFirst().orElseGet(() -> {
                    Chat chat = new Chat(id, id1, type);
                    list.add(chat);
                    owr.writeObjects(list);
                    return chat;
                });
    }
}
