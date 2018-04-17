package com.hebron.onlineshop.rest.services.impl;

import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.rest.services.LoginService;
import com.hebron.onlineshop.util.VoidOperationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CredentialsRepository repository;

    @Override
    public VoidOperationResult login(AuthorizationDTO authorization) {
        return repository.checkCredentials(authorization);
    }
}
