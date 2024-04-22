package uz.pdp.backend.model.group;

import uz.pdp.backend.model.BaseModel;

/**
 * The Group class represents a group entity with its properties and methods.
 * It extends the BaseModel class.
 */
public class Group extends BaseModel {

    private String name; // The name of the group
    private String userId; // The ID of the user who owns the group

    /**
     * Constructs a new Group object with the specified user ID and group name.
     * @param userId The ID of the user who owns the group.
     * @param name The name of the group.
     */
    public Group(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    /**
     * Returns the name of the group.
     * @return The name of the group.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the group.
     * @param name The new name to set for the group.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ID of the user who owns the group.
     * @return The ID of the user who owns the group.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Returns a string representation of the group.
     * @return The name of the group.
     */
    @Override
    public String toString() {
        return name;
    }
}
