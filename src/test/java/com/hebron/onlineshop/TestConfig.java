package com.hebron.onlineshop;

import com.hebron.onlineshop.data.repository.CredentialsRepository;
import com.hebron.onlineshop.rest.controllers.LoginControllerImp;
import com.hebron.onlineshop.rest.controllers.interfaces.LoginController;
import com.hebron.onlineshop.rest.services.LoginServiceImp;
import com.hebron.onlineshop.rest.services.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class TestConfig {

    @Bean
    @Qualifier("LoginController")
    public LoginController getLoginController() {
        return new LoginControllerImp();
    }

    @Bean
    @Qualifier("LoginService")
    public LoginService getLoginService() {
        return new LoginServiceImp();
    }

    @Bean
    @Qualifier("CredentialsRepository")
    public CredentialsRepository getCredentialsRepository() {
        return new CredentialsRepository();
    }
}
