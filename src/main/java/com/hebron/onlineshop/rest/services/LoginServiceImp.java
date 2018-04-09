package com.hebron.onlineshop.rest.services;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.rest.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private CredentialsRepository repository;

    public boolean isValidUser(AuthorizationDTO authorizationDTO) {
        String login = authorizationDTO.getLogin();
        String password = authorizationDTO.getPassword();

        return !(login == null || login.equals("")) && !(password == null || password.equals(""));
    }

    @Override
    public boolean login(AuthorizationDTO authorization) {
        return repository.saveCredentials(authorization.getLogin(), authorization.getPassword());
    }
}
