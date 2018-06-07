package com.hillel.dao.interfaces;

import com.hillel.dao.domains.Product;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    boolean create(T item);

    Optional<Product> findById(int id);

    List<T> findAll();

    void delete(T item);

    void deleteAll();

    void update(T item);

}
