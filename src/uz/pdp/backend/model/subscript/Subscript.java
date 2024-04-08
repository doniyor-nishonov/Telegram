package uz.pdp.backend.model.subscript;

import uz.pdp.backend.model.BaseModel;

public class Subscript extends BaseModel {
    private String userId;
    private String channelId;

    public Subscript(String userId, String channelId) {
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
