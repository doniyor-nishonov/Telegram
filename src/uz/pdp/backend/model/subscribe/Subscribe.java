package uz.pdp.backend.model.subscribe;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.BaseModel;

/**
 * The Subscribe class represents a subscription entity with its properties and methods.
 * It extends the BaseModel class.
 */
public class Subscribe extends BaseModel {

    private final String userId; // The ID of the user who is subscribing
    private final String channelId; // The ID of the channel being subscribed to
    private Role role; // The role of the user within the channel

    /**
     * Constructs a new Subscribe object with the specified user ID, channel ID, and default role.
     * @param userId The ID of the user who is subscribing.
     * @param channelId The ID of the channel being subscribed to.
     */
    public Subscribe(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
        this.role = Role.USER; // Default role is set to USER
    }

    /**
     * Returns the role of the user within the channel.
     * @return The role of the user.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the user within the channel.
     * @param role The new role to set for the user.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Returns the ID of the user who is subscribing.
     * @return The ID of the user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Returns the ID of the channel being subscribed to.
     * @return The ID of the channel.
     */
    public String getChannelId() {
        return channelId;
    }
}
