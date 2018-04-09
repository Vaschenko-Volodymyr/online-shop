package com.hebron.onlineshop.rest.services.interfaces;

import com.hebron.onlineshop.dto.AuthorizationDTO;

public interface LoginService {

    boolean isValidUser(AuthorizationDTO authorization);
    boolean login(AuthorizationDTO authorization);
}
