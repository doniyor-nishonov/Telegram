package uz.pdp.backend.model.subscript;

import uz.pdp.backend.model.BaseModel;

public class Subscribe extends BaseModel {
    private final String userId;
    private final String channelId;

    public Subscribe(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
    }

    public String getUserId() {
        return userId;
    }

    public String getChannelId() {
        return channelId;
    }
}