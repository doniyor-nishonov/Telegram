package uz.pdp.backend.model.message;

import uz.pdp.backend.model.BaseModel;

public class Message extends BaseModel {
    private String senderId;
    private String text;
    private String chatId;

    public Message(String senderId, String text, String chatId) {
        this.senderId = senderId;
        this.text = text;
        this.chatId = chatId;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return text;
    }
}
