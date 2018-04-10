package com.hebron.onlineshop.rest.controllers;

import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.dto.ResponseDTO;

public interface RegistrationController {

    ResponseDTO register(RegistrationDTO registration);
}
