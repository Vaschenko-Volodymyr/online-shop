package com.hebron.onlineshop.data.repository;

import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.util.VoidOperationResult;

public interface RegistrationRepository {

    VoidOperationResult register(RegistrationDTO registration);
}
