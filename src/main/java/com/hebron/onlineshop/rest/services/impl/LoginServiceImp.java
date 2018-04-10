package com.hebron.onlineshop.rest.services.impl;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.rest.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService {

    @Autowired
    private CredentialsRepository repository;

    @Override
    public boolean login(AuthorizationDTO authorization) {
        return repository.saveCredentials(authorization.getLogin(), authorization.getPassword());
    }
}
