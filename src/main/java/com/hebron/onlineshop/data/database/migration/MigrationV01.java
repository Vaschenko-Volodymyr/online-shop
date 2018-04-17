package com.hebron.onlineshop.data.database.migration;

import com.hebron.onlineshop.data.database.tables.CredentialsTable;

public class MigrationV01 extends AbstractMigration{

    @Override
    public void run() {
        String query = "CREATE TABLE IF NOT EXISTS " + CredentialsTable.NAME + " (" +
                CredentialsTable.LOGIN + " VARCHAR(30) UNIQUE PRIMARY KEY NOT NULL," +
                CredentialsTable.PASSWORD + " TEXT NOT NULL);";
        runSQLQuery(query);
    }
}
