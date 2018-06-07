package com.hillel.dao;


import com.hillel.dao.dblogic.ProductDbDao;
import com.hillel.dao.domains.Product;
import com.hillel.dao.interfaces.Dao;

import java.util.Optional;

public class DbDaoMain {
    public static void main(String[] args) {
//        Dao<Product> productDAO = new ProductMemoryDao();
        Dao<Product> productDAO = new ProductDbDao();
        productDAO.deleteAll();

        productDAO.create(new Product(1, "aaa", "bbb", 10));
        productDAO.create(new Product(2, "aaa", "bbb", 20));
        productDAO.create(new Product(3, "aaa", "bbb", 30));
        productDAO.create(new Product(4, "aaa", "bbb", 40));
        workWithProducts(productDAO);
    }

    private static void workWithProducts(Dao<Product> productDAO) {
        Optional<Product> product = productDAO.findById(3);
        if (!product.isPresent()) {
            return;
        }

        Product currentProduct = product.get();
        System.out.println("id = 3:" + currentProduct);
        currentProduct.setName("Crocodile");
        productDAO.update(currentProduct);
        System.out.println("after croco update: " + productDAO.findAll());

        productDAO.delete(currentProduct);
        productDAO.create(new Product(5, "Giraffe", "African animal", 111111));
        System.out.println("after croco delete and giraffe insert: " + productDAO.findAll());
    }
}