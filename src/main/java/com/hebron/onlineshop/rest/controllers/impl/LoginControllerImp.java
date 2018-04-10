package com.hebron.onlineshop.rest.controllers.impl;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.ResponseDTO;
import com.hebron.onlineshop.rest.controllers.LoginController;
import com.hebron.onlineshop.rest.services.LoginService;
import com.hebron.onlineshop.rest.util.ResponseUtils;
import com.hebron.onlineshop.util.Messages;
import com.hebron.onlineshop.util.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Slf4j
@RestController
public class LoginControllerImp implements LoginController {

    @Autowired
    private LoginService loginService;

    @Override
    @POST
    @RequestMapping("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDTO login(@RequestBody AuthorizationDTO authorization) {
        log.info("New login request");

        Validator.ValidationResult validationResult = Validator.validateLoginCredentials(authorization);
        if (validationResult.isValid()) {
            return ResponseUtils.buildBadRequest(
                    Messages.badCredentialsMessage(
                            authorization.getLogin(),
                            authorization.getPassword(),
                            validationResult.getReason())
            );
        } else {
            if (loginService.login(authorization)) {
                return ResponseUtils.buildOkResponse(Messages.SUCCESS);
            } else {
                return ResponseUtils.buildBadRequest(Messages.ERROR);
            }
        }
    }
}
