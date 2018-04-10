package com.hebron.onlineshop.data.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CredentialsRepository extends AbstractRepository {

    public boolean saveCredentials(String login, String password){
        String query = "INSERT INTO credentials VALUES(" +
                login + "," +
                password + ")";
        return executeQuery(query);
    }
}
