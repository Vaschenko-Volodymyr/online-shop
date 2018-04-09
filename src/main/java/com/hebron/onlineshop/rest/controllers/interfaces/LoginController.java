package com.hebron.onlineshop.rest.controllers.interfaces;

import com.hebron.onlineshop.dto.AuthorizationDTO;

import javax.ws.rs.core.Response;

public interface LoginController {

    Response login(AuthorizationDTO authorization);
}
