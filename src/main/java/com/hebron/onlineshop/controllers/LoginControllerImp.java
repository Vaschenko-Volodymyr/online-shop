package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.controllers.interfaces.LoginController;
import com.hebron.onlineshop.services.interfaces.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginControllerImp implements LoginController {

    @Autowired
    private LoginService loginService;

    @POST
    public Response login(String login, String password) {

        log.debug(">> login, login = {}, password = {}", login,password);
        if (loginService.isValidUser(login, password)){
            loginService.login(login,password);
            log.debug("<< login");
            return Response.status(Response.Status.OK).build();
        }else {
            log.debug("<< login");
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
