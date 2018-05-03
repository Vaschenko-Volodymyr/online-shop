package com.hebron.onlineshop;

import com.hebron.onlineshop.mocks.repository.CredentialsRepositoryMock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = TestConfig.class, loader=AnnotationConfigContextLoader.class)
public abstract class BaseTest extends AbstractTestNGSpringContextTests {

    protected void resetCredentials() {
        CredentialsRepositoryMock.reset();
    }

    protected void addCredentials(String login, String password) {
        CredentialsRepositoryMock.addLogin(login);
        CredentialsRepositoryMock.addPassword(password);
    }
}
