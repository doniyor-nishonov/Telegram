package uz.pdp.backend.model.message;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.BaseModel;

import java.time.format.DateTimeFormatter;

/**
 * The Message class represents a message entity within a chat with its properties and methods.
 * It extends the BaseModel class.
 */
public class Message extends BaseModel {

    private String text; // The text content of the message
    private final String senderId; // The ID of the sender of the message
    private final String chatId; // The ID of the chat the message belongs to
    private boolean state; // The state of the message (read/unread)
    private final MessageType type; // The type of the message

    /**
     * Constructs a new Message object with the specified text, sender ID, chat ID, and message type.
     * @param text The text content of the message.
     * @param senderId The ID of the sender of the message.
     * @param chatId The ID of the chat the message belongs to.
     * @param type The type of the message.
     */
    public Message(String text, String senderId, String chatId, MessageType type) {
        this.text = text;
        this.senderId = senderId;
        this.chatId = chatId;
        this.state = false; // Default state is set to false (unread)
        this.type = type;
    }

    /**
     * Returns the ID of the sender of the message.
     * @return The ID of the sender.
     */
    public String getSenderId() {
        return senderId;
    }

    /**
     * Sets the text content of the message.
     * @param text The new text content of the message.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Sets the state of the message (read/unread).
     * @param state The new state of the message.
     */
    public void setState(boolean state) {
        this.state = state;
    }


    /**
     * Returns the text content of the message.
     * @return The text content of the message.
     */
    public String getText() {
        return text;
    }

    /**
     * Returns the ID of the chat the message belongs to.
     * @return The ID of the chat.
     */
    public String getChatId() {
        return chatId;
    }


    /**
     * Returns the type of the message.
     * @return The type of the message.
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Returns a string representation of the message including text, state, and time.
     * @return A formatted string representation of the message.
     */
    @Override
    public String toString() {
        String s = state ? "**" : "*"; // Sets a visual indicator for read/unread messages
        String time = super.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm")); // Formats the creation time
        return """
                %s%s
                                    %s
                """.formatted(text, s, time); // Formats the message with text, state, and time
    }
}
