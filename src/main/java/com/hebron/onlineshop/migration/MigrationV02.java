package com.hebron.onlineshop.migration;

import java.sql.SQLException;

public class MigrationV02 extends AbstractMigration {

    public MigrationV02() throws SQLException {
    }

    @Override
    public void run() {
        System.out.println("Dummy migration");
    }
}
