package uz.pdp.backend.model.userGroup;

import uz.pdp.backend.model.BaseModel;

import java.io.Serializable;

public class UserGroup extends BaseModel {
    private final String userId;
    private final String groupId;
    public UserGroup(String userId, String groupId) {
        this.userId = userId;
        this.groupId = groupId;
    }
    public String getUserId() {
        return userId;
    }
    public String getGroupId() {
        return groupId;
    }
}
