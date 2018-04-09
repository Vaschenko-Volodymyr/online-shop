package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.TestConfig;
import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.rest.controllers.interfaces.LoginController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)

public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    public void testLogin(){
        Response response = loginController.login(getAuthorizationDTO("testUser", "12345678"));
        assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
    }

    @Test
    public void testWrongCredentials() {
        Response response = loginController.login(getAuthorizationDTO("", ""));
        assertTrue(response.getStatus() == Response.Status.BAD_REQUEST.getStatusCode());
    }

    private AuthorizationDTO getAuthorizationDTO(String login, String password) {
        AuthorizationDTO dto = new AuthorizationDTO();
        dto.setLogin(login);
        dto.setPassword(password);
        return dto;
    }
}
