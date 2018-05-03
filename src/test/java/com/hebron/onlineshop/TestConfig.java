package com.hebron.onlineshop;

import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.data.repository.RegistrationRepository;
import com.hebron.onlineshop.mocks.repository.CredentialsRepositoryMock;
import com.hebron.onlineshop.mocks.repository.RegistrationRepositoryMock;
import com.hebron.onlineshop.rest.controllers.LoginController;
import com.hebron.onlineshop.rest.controllers.RegistrationController;
import com.hebron.onlineshop.rest.controllers.impl.LoginControllerImp;
import com.hebron.onlineshop.rest.controllers.impl.RegistrationControllerImpl;
import com.hebron.onlineshop.rest.services.LoginService;
import com.hebron.onlineshop.rest.services.RegistrationService;
import com.hebron.onlineshop.rest.services.impl.LoginServiceImpl;
import com.hebron.onlineshop.rest.services.impl.RegistrationServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class TestConfig {

    // Controllers
    @Bean
    public LoginController loginController() {
        return new LoginControllerImp();
    }

    @Bean
    public RegistrationController registrationController() {
        return new RegistrationControllerImpl();
    }

    // Services
    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl();
    }

    @Bean
    public RegistrationService registrationService() {
        return new RegistrationServiceImpl();
    }

    //Repositories
    @Bean
    public CredentialsRepository credentialsRepository() {
        return new CredentialsRepositoryMock();
    }

    @Bean
    public RegistrationRepository registrationRepository() {
        return new RegistrationRepositoryMock();
    }
}
