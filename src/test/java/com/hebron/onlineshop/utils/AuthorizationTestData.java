package com.hebron.onlineshop.utils;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import lombok.Getter;

@Getter
public class AuthorizationTestData extends TestData{

    private AuthorizationDTO authorization = new AuthorizationDTO();

    public AuthorizationTestData withLogin(String login) {
        authorization.setLogin(login);
        return this;
    }

    public AuthorizationTestData withPassword(String password) {
        authorization.setPassword(password);
        return this;
    }
}
