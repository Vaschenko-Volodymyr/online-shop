package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.dto.ResponseDTO;
import com.hebron.onlineshop.rest.controllers.LoginController;
import com.hebron.onlineshop.util.Messages;
import com.hebron.onlineshop.utils.AuthorizationTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.hebron.onlineshop.util.Messages.badCredentialsMessage;
import static com.hebron.onlineshop.util.Validator.emptyField;
import static org.junit.Assert.assertEquals;

@Test
public class LoginControllerTest extends UserControllerTest {

    private static final String LOGIN_CONTROLLER_DATA = "loginControllerTest";

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Autowired
    private LoginController loginController;

    @DataProvider(name = LOGIN_CONTROLLER_DATA)
    public Object[][] getLoginData() {
        return new Object[][]{

                // positive test case
                {new AuthorizationTestData()
                        .withLogin(USER_LOGIN)
                        .withPassword(USER_PASSWORD)
                        .shouldPass(true)
                        .withExpectedHTTPCode(200)},

                // negative test cases
                {new AuthorizationTestData()
                        .withLogin("nonexistent" + USER_LOGIN)
                        .withPassword(USER_PASSWORD)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(Messages.WRONG_CREDENTIALS)},

                {new AuthorizationTestData()
                        .withLogin(USER_LOGIN)
                        .withPassword("nonexistent" + USER_PASSWORD)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(Messages.WRONG_CREDENTIALS)},

                {new AuthorizationTestData()
                        .withLogin("nonexistent" + USER_LOGIN)
                        .withPassword("nonexistent" + USER_PASSWORD)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(Messages.WRONG_CREDENTIALS)},

                {new AuthorizationTestData()
                        .withLogin(USER_LOGIN)
                        .withPassword("")
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(PASSWORD)))},

                {new AuthorizationTestData()
                        .withLogin(USER_LOGIN)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(PASSWORD)))},

                {new AuthorizationTestData()
                        .withLogin("")
                        .withPassword(USER_PASSWORD)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))},

                {new AuthorizationTestData()
                        .withPassword(USER_PASSWORD)
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))},

                {new AuthorizationTestData()
                        .withLogin("")
                        .withPassword("")
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))},

                {new AuthorizationTestData()
                        .withLogin("")
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))},

                {new AuthorizationTestData()
                        .withPassword("")
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))},

                {new AuthorizationTestData()
                        .shouldPass(false)
                        .withExpectedHTTPCode(400)
                        .withExpectedErrorMessage(badCredentialsMessage(emptyField(LOGIN)))}
        };
    }

    @Test(dataProvider = LOGIN_CONTROLLER_DATA)
    public void loginTest(AuthorizationTestData testData) {
        ResponseDTO response = loginController.login(testData.getAuthorization());

        assertEquals(testData.getExpectedHttpCode(), response.getResponseCode());

        if (!testData.isPositive()) {
            assertEquals(testData.getExpectedErrorMessage(), response.getErrorMessage());
        }
    }
}
