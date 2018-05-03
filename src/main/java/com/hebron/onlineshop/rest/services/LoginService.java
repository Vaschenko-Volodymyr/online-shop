package com.hebron.onlineshop.rest.services;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.util.VoidOperationResult;

public interface LoginService {

    VoidOperationResult login(AuthorizationDTO authorization);
}
