package uz.pdp.backend.model.chat;

import uz.pdp.backend.model.BaseModel;

public class Chat extends BaseModel {
    private final String userId1;
    private final String userId2;
    private boolean state;

    public Chat(String userId1, String userId2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.state = false;
    }

    public String getUserId1() {
        return userId1;
    }

    public String getUserId2() {
        return userId2;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
