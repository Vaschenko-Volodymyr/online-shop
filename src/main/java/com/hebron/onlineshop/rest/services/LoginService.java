package com.hebron.onlineshop.rest.services;

import com.hebron.onlineshop.dto.AuthorizationDTO;

public interface LoginService {

    boolean login(AuthorizationDTO authorization);
}
