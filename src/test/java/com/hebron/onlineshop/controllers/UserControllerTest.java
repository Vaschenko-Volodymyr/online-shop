package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract class UserControllerTest extends BaseTest {

    static final String USER_LOGIN = "username";
    static final String USER_PASSWORD = "password";

    @BeforeTest
    public void initTestData() {
        resetCredentials();
        addCredentials(USER_LOGIN, USER_PASSWORD);
    }

    @AfterTest
    public void clear() {
        resetCredentials();
    }

}
