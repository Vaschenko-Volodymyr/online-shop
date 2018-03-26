package com.hebron.onlineshop.services;

import com.hebron.onlineshop.services.interfaces.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {
    public boolean isValidUser(String login, String password) {
        return false;
    }
}
