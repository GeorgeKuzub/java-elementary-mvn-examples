package com.hillel.db.dao.dblogic;


import com.hillel.db.dao.domains.Product;
import com.hillel.db.dao.interfaces.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductDbDao implements Dao<Product> {
    private Connection connection;

    public ProductDbDao() {
        System.setProperty("jdbc.drivers", "org.postgresql.Driver");

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/main",
                    "postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean create(Product product) {
        String sql =
                " INSERT INTO product (id, name, category, price)" +
                        " VALUES (?, ?, ?, ?)";
        int rowsInserted = -1;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getCategory());
            statement.setInt(4, product.getPrice());

            rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsInserted == 1;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, category, price FROM product";
        List<Product> products = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                Product product = new Product(id, name, category, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (products.isEmpty()) {
            return Collections.emptyList();
        } else {
            return products;
        }
    }

    @Override
    public Optional<Product> findById(int id) {
        String sql =
                "SELECT name, category, price " +
                        " FROM product" +
                        " WHERE id=" + id;

        Product result = null;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                int price = resultSet.getInt("price");
                result = new Product(id, name, category, price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(result);
    }

    @Override
    public void update(Product product) {
        String sql =
                "UPDATE product SET price = ?, name = ?, category = ? " +
                        " WHERE id = ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getPrice());
            statement.setString(2, product.getName());
            statement.setString(3, product.getCategory());
            statement.setInt(4, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Product product) {
        String sql =
                "DELETE FROM product WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getId());
            int rowsDeleted = statement.executeUpdate();
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAll() {
        String sql =
                "DELETE FROM product";
        try (Statement statement = connection.createStatement()) {
            int rowsDeleted = statement.executeUpdate(sql);
            System.out.println("Rows deleted: " + rowsDeleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
