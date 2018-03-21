package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.controllers.interfaces.LoginController;
import com.hebron.onlineshop.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.POST;
import javax.ws.rs.core.Response;

@Controller
@RequestMapping("/login")
public class LoginControllerImp implements LoginController {

    @Autowired
    private LoginService loginService;

    @POST
    public Response login(String login, String password) {

        if (loginService.isValidUser(login, password)){
            return Response.status(Response.Status.OK).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
