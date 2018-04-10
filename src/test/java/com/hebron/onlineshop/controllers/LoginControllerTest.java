package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.TestConfig;
import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.ResponseDTO;
import com.hebron.onlineshop.rest.controllers.LoginController;
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
        ResponseDTO response = loginController.login(getAuthorizationDTO("testUser", "12345678"));
        assertTrue(response.getResponseCode() == Response.Status.OK.getStatusCode());
    }

    @Test
    public void testWrongCredentials() {
        ResponseDTO response = loginController.login(getAuthorizationDTO("", ""));
        assertTrue(response.getResponseCode() == Response.Status.BAD_REQUEST.getStatusCode());
    }

    private AuthorizationDTO getAuthorizationDTO(String login, String password) {
        AuthorizationDTO dto = new AuthorizationDTO();
        dto.setLogin(login);
        dto.setPassword(password);
        return dto;
    }
}
