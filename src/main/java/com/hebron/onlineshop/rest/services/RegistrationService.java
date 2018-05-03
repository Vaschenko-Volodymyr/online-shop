package com.hebron.onlineshop.rest.services;

import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.util.VoidOperationResult;

public interface RegistrationService {

    VoidOperationResult register(RegistrationDTO registration);
}
