package uz.pdp.backend.model.message;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.BaseModel;

import java.time.format.DateTimeFormatter;

public class Message extends BaseModel {
    private String text;
    private final String senderId;
    private final String chatId;
    private boolean state;
    private MessageType type;

    public Message(String text, String senderId, String chatId, MessageType type) {
        this.text = text;
        this.senderId = senderId;
        this.chatId = chatId;
        this.state = false;
        this.type = type;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public String getChatId() {
        return chatId;
    }

    public boolean getState() {
        return state;
    }

    public MessageType getType() {
        return type;
    }

    @Override
    public String toString() {
        String s = state ? "**" : "*";
        String time = super.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm"));
        return """
                %s%s
                                    %s
                """.formatted(text, s, time);
    }
}
