package uz.pdp.backend.model.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.BaseModel;

/**
 * The Chat class represents a chat entity between two users with its properties and methods.
 * It extends the BaseModel class.
 */
public class Chat extends BaseModel {

    private final String id1; // The ID of the first participant in the chat
    private final String id2; // The ID of the second participant in the chat
    private final MessageType type; // The type of the chat message

    /**
     * Constructs a new Chat object with the specified participant IDs and message type.
     * @param id1 The ID of the first participant in the chat.
     * @param id2 The ID of the second participant in the chat.
     * @param type The type of the chat message.
     */
    public Chat(String id1, String id2, MessageType type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }

    /**
     * Returns the type of the chat message.
     * @return The type of the chat message.
     */
    public MessageType getType() {
        return type;
    }


    /**
     * Returns the ID of the first participant in the chat.
     * @return The ID of the first participant in the chat.
     */
    public String getId1() {
        return id1;
    }

    /**
     * Returns the ID of the second participant in the chat.
     * @return The ID of the second participant in the chat.
     */
    public String getId2() {
        return id2;
    }
}
