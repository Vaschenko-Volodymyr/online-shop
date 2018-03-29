package com.hebron.onlineshop.services;

import com.hebron.onlineshop.repository.CredentialsRepository;
import com.hebron.onlineshop.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private CredentialsRepository repository;

    @Override
    public boolean isValidUser(String login, String password) {
        return true;
    }

    @Override
    public void login(String login, String password){
        repository.saveCredentials(login,password);
    }
}
