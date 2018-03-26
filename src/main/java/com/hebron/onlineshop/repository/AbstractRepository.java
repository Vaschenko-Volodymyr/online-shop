package com.hebron.onlineshop.repository;

import com.hebron.onlineshop.database.Database;
import com.hebron.onlineshop.database.MySQLDatabase;

import java.sql.Connection;
import java.sql.SQLException;

abstract class AbstractRepository {

    protected final Connection connection;

    AbstractRepository(){
        try {
            Database database = new MySQLDatabase();
            connection = database.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Unable to create connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            // ignore
        }
    }
}
