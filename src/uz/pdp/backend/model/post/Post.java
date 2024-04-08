package uz.pdp.backend.model.post;

import uz.pdp.backend.model.BaseModel;

public class Post extends BaseModel {
    private String title;
    private String channelId;

    public Post(String title, String channelId) {
        this.title = title;
        this.channelId = channelId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelId() {
        return channelId;
    }

    @Override
    public String toString() {
        return title;
    }
}
