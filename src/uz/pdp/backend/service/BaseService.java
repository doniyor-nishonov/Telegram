package uz.pdp.backend.service;

import uz.pdp.backend.model.BaseModel;

import java.util.List;

/**
 * Base service interface defining common CRUD operations.
 *
 * @param <E> the type of entity extending BaseModel
 */
public interface BaseService<E extends BaseModel> {

    /**
     * Adds a new entity to the repository.
     *
     * @param e the entity to be added
     * @return true if the entity is successfully added, false otherwise
     */
    boolean add(E e);

    /**
     * Deletes an entity from the repository by its ID.
     *
     * @param id the ID of the entity to be deleted
     * @return true if the entity is successfully deleted, false otherwise
     */
    boolean delete(String id);

    /**
     * Updates an existing entity in the repository.
     *
     * @param newE the updated entity object
     * @return true if the entity is successfully updated, false otherwise
     */
    boolean update(E newE);

    /**
     * Retrieves all entities from the repository.
     *
     * @return a list of all entities
     */
    List<E> getAll();

    /**
     * Retrieves an entity from the repository by its ID.
     *
     * @param id the ID of the entity to retrieve
     * @return the entity object if found, null otherwise
     */
    E get(String id);
}
