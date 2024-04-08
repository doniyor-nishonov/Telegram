package uz.pdp.backend.model.channel;

import uz.pdp.backend.enums.Type;
import uz.pdp.backend.model.BaseModel;

public class Channel extends BaseModel {
    private String name;
    private String userId;
    private Type type;

    public Channel(String name, String userId, Type type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
