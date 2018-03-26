package com.hebron.onlineshop.services.interfaces;

public interface LoginService {

    boolean isValidUser(String login, String password);
    void login(String login, String password);
}
