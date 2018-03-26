package com.hebron.onlineshop.migration;

import java.sql.SQLException;
import java.sql.Statement;

public class MigrationV01 extends AbstractMigration{

    public MigrationV01() throws SQLException {
    }

    @Override
    public void run() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS credentials(" +
                    "login VARCHAR(30) UNIQUE PRIMARY KEY NOT NULL," +
                    "password TEXT NOT NULL);");
        } catch (SQLException e) {
            try {
                connection.close();
            } catch (SQLException ignored) {}
            throw new RuntimeException(e.getMessage());
        }
    }
}
