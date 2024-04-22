package uz.pdp.backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The BaseModel class serves as a base class for other model classes.
 * It provides common properties and methods for model classes.
 */
public abstract class BaseModel implements Serializable {

    private  String id; // The unique identifier for the model object
    private  LocalDateTime createdAt; // The timestamp when the model object was created

    /**
     * Constructs a new BaseModel object with a generated unique ID and creation timestamp.
     */
    public BaseModel() {
        this.id = UUID.randomUUID().toString(); // Generates a unique ID
        this.createdAt = LocalDateTime.now(); // Sets the creation timestamp to the current time
    }

    /**
     * Returns the unique identifier of the model object.
     * @return The unique identifier.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the timestamp when the model object was created.
     * @return The creation timestamp.
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
