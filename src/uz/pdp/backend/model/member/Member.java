package uz.pdp.backend.model.member;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.BaseModel;


public class Member extends BaseModel {
    private final String userId;
    private final String groupId;
    private Role role;
    private boolean status;

    public Member(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
        this.role = Role.USER;
        this.status = false;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getGroupId() {
        return groupId;
    }
}
