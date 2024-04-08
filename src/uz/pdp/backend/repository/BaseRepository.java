package uz.pdp.backend.repository;

import java.util.ArrayList;
import java.util.List;

public interface BaseRepository<E> {
    boolean add(E e);
    boolean delete(String id);
    boolean update(String id,E newE);
    List<E> getAll();
    E get(String id);
}
