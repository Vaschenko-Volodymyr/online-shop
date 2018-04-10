package com.hebron.onlineshop.rest.controllers.impl;

import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.dto.ResponseDTO;
import com.hebron.onlineshop.rest.controllers.RegistrationController;
import com.hebron.onlineshop.rest.services.RegistrationService;
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
public class RegistrationControllerImpl implements RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Override
    @POST
    @RequestMapping("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseDTO register(@RequestBody RegistrationDTO registration) {
        log.info("Registration request for {} {}", registration.getFirstName(), registration.getSecondName());

        Validator.ValidationResult validationResult = Validator.validateRegistration(registration);

        if (!validationResult.isValid()) {
            return ResponseUtils.buildBadRequest(
                    Messages.badRegistrationInfo(validationResult.getReason()));
        }

        if (registrationService.register(registration)) {
            return ResponseUtils.buildOkResponse(Messages.SUCCESS);
        } else {
            return ResponseUtils.buildBadRequest(Messages.ERROR);
        }
    }
}
