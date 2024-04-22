package uz.pdp.backend.model.post;

import uz.pdp.backend.model.BaseModel;

import java.time.format.DateTimeFormatter;

/**
 * The Post class represents a post entity within a channel with its properties and methods.
 * It extends the BaseModel class.
 */
public class Post extends BaseModel {

    private String title; // The title of the post
    private String channelId; // The ID of the channel the post belongs to

    /**
     * Constructs a new Post object with the specified title and channel ID.
     * @param title The title of the post.
     * @param channelId The ID of the channel the post belongs to.
     */
    public Post(String title, String channelId) {
        this.title = title;
        this.channelId = channelId;
    }

    /**
     * Sets the title of the post.
     * @param title The new title to set for the post.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the ID of the channel the post belongs to.
     * @return The ID of the channel.
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * Returns a string representation of the post including title and creation time.
     * @return A formatted string representation of the post.
     */
    @Override
    public String toString() {
        return """
                %s
                %s
                """.formatted(title, super.getCreatedAt().format(DateTimeFormatter.ofPattern("HH:mm")));
    }
}
