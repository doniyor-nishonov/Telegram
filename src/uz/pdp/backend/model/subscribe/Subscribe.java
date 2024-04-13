package uz.pdp.backend.model.subscribe;

import uz.pdp.backend.enums.Role;
import uz.pdp.backend.model.BaseModel;

public class Subscribe extends BaseModel {
    private final String userId;
    private final String channelId;
    private Role role;

    public Subscribe(String userId, String channelId) {
        this.userId = userId;
        this.channelId = channelId;
        this.role = Role.USER;
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

    public String getChannelId() {
        return channelId;
    }
}
