package com.hebron.onlineshop.data.database.migration;

import com.hebron.onlineshop.data.database.MySQLDatabase;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
abstract class AbstractMigration implements Migration {

    void runSQLQuery(String query) {
        MySQLDatabase database = new MySQLDatabase();
        try (Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute(query);
        } catch (SQLException e) {
            log.error("Error while executing query {}", query);
        }
    }
}
