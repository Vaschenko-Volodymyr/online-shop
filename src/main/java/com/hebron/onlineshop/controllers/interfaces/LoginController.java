package com.hebron.onlineshop.controllers.interfaces;

import javax.ws.rs.core.Response;

public interface LoginController {

    Response login(String login, String password);
}
