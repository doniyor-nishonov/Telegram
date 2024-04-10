package uz.pdp.backend.model.chat;

import uz.pdp.backend.model.BaseModel;

public class Chat extends BaseModel {
    private final String id1;
    private final String id2;

    public Chat(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }

    public String getId1() {
        return id1;
    }

    public String getId2() {
        return id2;
    }
}
