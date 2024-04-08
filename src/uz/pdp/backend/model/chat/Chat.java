package uz.pdp.backend.model.chat;

import uz.pdp.backend.model.BaseModel;

public class Chat extends BaseModel {
    private final String userId1;
    private final String userId2;

    public Chat(String userId1, String userId2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
    }

    public String getUserId1() {
        return userId1;
    }

    public String getUserId2() {
        return userId2;
    }
}
