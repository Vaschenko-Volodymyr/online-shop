package com.hebron.onlineshop.data.repository.impl;

import com.hebron.onlineshop.data.database.Database;
import com.hebron.onlineshop.data.database.MySQLDatabase;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
abstract class AbstractRepository {

    private final Database database = new MySQLDatabase();

    @Getter
    @Setter
    class DatabaseResponse {

        private boolean success;
        private String errorMessage;
    }

    DatabaseResponse executeQuery(String query) {
        DatabaseResponse message = new DatabaseResponse();
        try (Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(query);
            message.setSuccess(true);
            return message;
        } catch (SQLException e) {
            log.error("Unable to execute query {} due to {}", query, e.getMessage());
            message.setSuccess(false);
            message.setErrorMessage(e.getMessage());
            return message;
        }
    }
}
