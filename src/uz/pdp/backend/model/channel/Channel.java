package uz.pdp.backend.model.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.model.BaseModel;

public class Channel extends BaseModel {
    private String name;
    private String userId;
    private ChannelType channelType;

    public Channel(String name, String userId, ChannelType channelType) {
        this.name = name;
        this.userId = userId;
        this.channelType = channelType;
    }

    public ChannelType getType() {
        return channelType;
    }

    public void setType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return name;
    }
}
