package com.hebron.onlineshop.data.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabase implements Database, AutoCloseable {

    private static final String url = "jdbc:mysql://localhost:3306/onlineshop";
    private static final String username = "root";
    private static final String password = "root";
    private Connection connection;

    @Override
    public synchronized Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Connected to database!");
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        System.out.println("Closed connection!");
    }
}
