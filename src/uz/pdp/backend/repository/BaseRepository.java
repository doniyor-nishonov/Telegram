package uz.pdp.backend.repository;

import uz.pdp.backend.model.BaseModel;

import java.util.List;

public interface BaseRepository<E extends BaseModel> {
    boolean add(E e);
    boolean delete(String id);
    boolean update(E newE);
    List<E> getAll();
    E get(String id);
}
