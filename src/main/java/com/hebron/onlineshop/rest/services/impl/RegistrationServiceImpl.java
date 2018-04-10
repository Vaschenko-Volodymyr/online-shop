package com.hebron.onlineshop.rest.services.impl;

import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.rest.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public boolean register(RegistrationDTO registration) {
        log.error("NOT IMPLEMENTED!");
        return false;
    }
}
