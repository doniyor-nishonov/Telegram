package uz.pdp.backend.model.post;

import uz.pdp.backend.model.BaseModel;

import java.time.format.DateTimeFormatter;

public class Post extends BaseModel {
    private String title;
    private final String channelId;

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
        return """
                %s
                %s
                """.formatted(title,super.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
