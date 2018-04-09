package com.hebron.onlineshop.rest.controllers;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.ErrorDTO;
import com.hebron.onlineshop.rest.controllers.interfaces.LoginController;
import com.hebron.onlineshop.rest.services.interfaces.LoginService;
import com.hebron.onlineshop.rest.util.ResponseUtils;
import com.hebron.onlineshop.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Controller
public class LoginControllerImp implements LoginController {

    @Autowired
    private LoginService loginService;

    @POST
    @RequestMapping("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(@RequestBody AuthorizationDTO authorization) {

        if (loginService.isValidUser(authorization)) {
            return ResponseUtils.buildOkResponse(
                    new ErrorDTO().setErrorMessage(
                            Messages.badCredentialsMessage(
                                    authorization.getLogin(),
                                    authorization.getPassword())
                    )
            );
        } else {
            boolean success = loginService.login(authorization);
            if (success) {
                return ResponseUtils.buildOkResponse(Messages.SUCCESS);
            } else {
                return ResponseUtils.buildBadRequest(Messages.ERROR);
            }

        }
    }
}
