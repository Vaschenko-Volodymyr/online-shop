package com.hebron.onlineshop.data.database.migration;

public class MigrationV01 extends AbstractMigration{

    @Override
    public void run() {
        String query = "CREATE TABLE IF NOT EXISTS credentials(" +
                "login VARCHAR(30) UNIQUE PRIMARY KEY NOT NULL," +
                "password TEXT NOT NULL);";
        runSQLQuery(query);
    }
}
