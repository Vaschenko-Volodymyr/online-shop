package com.hebron.onlineshop.data.repository;

import com.hebron.onlineshop.data.database.Database;
import com.hebron.onlineshop.data.database.MySQLDatabase;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
abstract class AbstractRepository {

    private final Database database = new MySQLDatabase();

    protected boolean exequteQuery(String query) {
        try (Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            log.error("Unable to execute query {} due to {}", query, e.getMessage());
            return false;
        }
        return true;
    }
}
