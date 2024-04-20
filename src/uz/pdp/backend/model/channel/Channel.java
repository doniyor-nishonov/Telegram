package uz.pdp.backend.model.channel;

import uz.pdp.backend.enums.ChannelType;
import uz.pdp.backend.model.BaseModel;

/**
 * The Channel class represents a channel entity with its properties and methods.
 * It extends the BaseModel class.
 */
public class Channel extends BaseModel {

    private String name; // The name of the channel
    private final String ownerId; // The ID of the owner of the channel
    private final ChannelType channelType; // The type of the channel

    /**
     * Constructs a new Channel object with the specified name, owner ID, and channel type.
     * @param name The name of the channel.
     * @param ownerId The ID of the owner of the channel.
     * @param channelType The type of the channel.
     */
    public Channel(String name, String ownerId, ChannelType channelType) {
        this.name = name;
        this.ownerId = ownerId;
        this.channelType = channelType;
    }

    /**
     * Returns the type of the channel.
     * @return The channel type.
     */
    public ChannelType getType() {
        return channelType;
    }
    /**
     * Returns the name of the channel.
     * @return The name of the channel.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the channel.
     * @param name The new name to set for the channel.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the owner of the channel.
     * @return The owner ID of the channel.
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * Returns a string representation of the channel.
     * @return The name of the channel.
     */
    @Override
    public String toString() {
        return name;
    }
}
