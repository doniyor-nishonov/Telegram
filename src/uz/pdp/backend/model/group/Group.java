package uz.pdp.backend.model.group;

import uz.pdp.backend.model.BaseModel;


public class Group extends BaseModel{
    private String name;
    private final String userId;

    public Group(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return name;
    }
}
