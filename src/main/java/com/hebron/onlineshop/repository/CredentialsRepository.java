package com.hebron.onlineshop.repository;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CredentialsRepository extends AbstractRepository {

    public void saveCredentials(String login, String password){
        try(Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO credentials VALUES(" +
                    login + "," +
                    password + ")");
        } catch (SQLException e) {
            // TODO: handle duplicate values exception
            try {
                connection.close();
            } catch (SQLException e1) {
                // ignore
            }
        }
    }
}
