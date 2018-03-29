package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.TestConfig;
import com.hebron.onlineshop.controllers.interfaces.LoginController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.ws.rs.core.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)

public class LoginControllerTest {

    @Autowired
    private LoginController loginController;

    @Test
    public void testLogin(){
        String login = "testUser";
        String password = "12345678";

        Response response = loginController.login(login,password);
        Assert.assertTrue(response.getStatus() == Response.Status.OK.getStatusCode());
    }
}
