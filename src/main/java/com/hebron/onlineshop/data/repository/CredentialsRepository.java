package com.hebron.onlineshop.data.repository;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CredentialsRepository extends AbstractRepository {

    public boolean saveCredentials(String login, String password){
        String query = "INSERT INTO credentials VALUES(" +
                login + "," +
                password + ")";
        return exequteQuery(query);
    }
}
