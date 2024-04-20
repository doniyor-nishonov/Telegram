package uz.pdp.backend.model.member;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.BaseModel;

/**
 * The Member class represents a member entity within a group with its properties and methods.
 * It extends the BaseModel class.
 */
public class Member extends BaseModel {
    
    private final String userId; // The ID of the user who is a member
    private final String groupId; // The ID of the group the user is a member of
    private Role role; // The role of the member within the group

    /**
     * Constructs a new Member object with the specified user ID, group ID, and default role.
     * @param userId The ID of the user who is a member.
     * @param groupId The ID of the group the user is a member of.
     */
    public Member(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
        this.role = Role.USER; // Default role is set to USER
    }

    /**
     * Returns the role of the member within the group.
     * @return The role of the member.
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets the role of the member within the group.
     * @param role The new role to set for the member.
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Returns the ID of the user who is a member.
     * @return The ID of the user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Returns the ID of the group the user is a member of.
     * @return The ID of the group.
     */
    public String getGroupId() {
        return groupId;
    }
}
