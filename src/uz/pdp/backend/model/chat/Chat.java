package uz.pdp.backend.model.chat;

import uz.pdp.backend.enums.MessageType;
import uz.pdp.backend.model.BaseModel;

public class Chat extends BaseModel {
    private final String id1;
    private final String id2;
    private MessageType type;

    public Chat(String id1, String id2, MessageType type) {
        this.id1 = id1;
        this.id2 = id2;
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getId1() {
        return id1;
    }

    public String getId2() {
        return id2;
    }
}
