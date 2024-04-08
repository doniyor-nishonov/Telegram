package uz.pdp.backend.service;

import java.util.List;

public interface BaseService<E> {
    boolean add(E e);
    boolean delete(String id);
    boolean update(String id,E newE);
    List<E> getAll();
    E get(String id);
}
