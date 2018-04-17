package com.hebron.onlineshop.rest.services.impl;

import com.hebron.onlineshop.data.repository.RegistrationRepository;
import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.rest.services.RegistrationService;
import com.hebron.onlineshop.util.VoidOperationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public VoidOperationResult register(RegistrationDTO registration) {
        return registrationRepository.register(registration);
    }
}
