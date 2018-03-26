package com.hebron.onlineshop.migration;

import com.hebron.onlineshop.database.MySQLDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractMigration implements Migration {

    protected final Connection connection;

    public AbstractMigration() throws SQLException {

        MySQLDatabase database = new MySQLDatabase();
        connection = database.getConnection();
    }
}
