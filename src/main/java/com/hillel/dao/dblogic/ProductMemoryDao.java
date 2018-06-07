package com.hillel.dao.dblogic;

import com.hillel.dao.domains.Product;
import com.hillel.dao.interfaces.Dao;

import java.util.*;

public class ProductMemoryDao implements Dao<Product> {
    private Map<Integer, Product> products = new HashMap<>();

    @Override
    public boolean create(Product product) {
        products.put(product.getId(), product);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public void update(Product product) {
        create(product);
    }

    @Override
    public void delete(Product product) {
        products.remove(product.getId());
    }

    @Override
    public void deleteAll() {
        products.clear();
    }
}
