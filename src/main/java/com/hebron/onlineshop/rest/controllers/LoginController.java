package com.hebron.onlineshop.rest.controllers;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.ResponseDTO;

public interface LoginController {

    ResponseDTO login(AuthorizationDTO authorization);
}
