package com.hillel.db.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db_Basic {
    public static void main(String[] args) throws Exception {


        Connection connection = null;

        //Registering the JDBC driver
        Class.forName("org.postgresql.Driver");

        //Creating the connection with the DB
        connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/main",
                "postgres", "root");


//        Connection connnection = DriverManager
//                .getConnection("jdbc:mysql://localhost:3306/dbName", "root", "password");

        if (connection != null) {
            System.out.println("Connection created successfully");

        } else {
            System.out.println("Problem with creating connection");
        }


        Statement stmt;
        String sql;

        stmt = connection.createStatement();
        sql = "CREATE TABLE IF NOT EXISTS company" +
                "(ID INTEGER PRIMARY KEY     NOT NULL," +
                " NAME           VARCHAR(200)    NOT NULL, " +
                " AGE            INTEGER     NOT NULL, " +
                " ADDRESS        CHAR(50), " +
                " SALARY         REAL)";
        stmt.executeUpdate(sql);
        stmt.close();

        connection.setAutoCommit(false);

        stmt = connection.createStatement();
        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (1, 'Paul', 32, 'California', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
        stmt.executeUpdate(sql);

        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
        stmt.executeUpdate(sql);

        stmt.close();
        connection.commit();

        stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();

        stmt = connection.createStatement();
        sql = "UPDATE COMPANY SET SALARY = 25000.00 WHERE ID=1;";
        stmt.executeUpdate(sql);
        connection.commit();

        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();

        stmt = connection.createStatement();
        sql = "DELETE FROM COMPANY WHERE ID=2;";
        stmt.executeUpdate(sql);
        connection.commit();

        rs = stmt.executeQuery("SELECT * FROM COMPANY;");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String address = rs.getString("address");
            float salary = rs.getFloat("salary");
            System.out.println("ID = " + id);
            System.out.println("NAME = " + name);
            System.out.println("AGE = " + age);
            System.out.println("ADDRESS = " + address);
            System.out.println("SALARY = " + salary);
            System.out.println();
        }
        rs.close();
        stmt.close();
        connection.close();
    }
}