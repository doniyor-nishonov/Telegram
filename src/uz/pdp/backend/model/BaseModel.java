package uz.pdp.backend.model;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseModel implements Serializable {
    private final String id;

    public BaseModel() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }
}
