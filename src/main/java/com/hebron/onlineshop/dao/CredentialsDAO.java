package com.hebron.onlineshop.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CredentialsDAO {

    private String login;
    private String password;

    public CredentialsDAO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CredentialsDAO() {

    }
}
