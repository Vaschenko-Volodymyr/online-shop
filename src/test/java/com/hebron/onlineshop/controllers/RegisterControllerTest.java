package com.hebron.onlineshop.controllers;

import com.hebron.onlineshop.dto.ResponseDTO;
import com.hebron.onlineshop.rest.controllers.RegistrationController;
import com.hebron.onlineshop.util.units.Day;
import com.hebron.onlineshop.util.units.Gender;
import com.hebron.onlineshop.util.units.Month;
import com.hebron.onlineshop.utils.RegistrationTestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterControllerTest extends UserControllerTest {

    private static final String REGISTER_DATA_PROVIDER = "registerDataProvider";

    @Autowired
    private RegistrationController registrationController;

    @DataProvider(name = REGISTER_DATA_PROVIDER)
    public Object[][] getRegistrationData() {
        return new Object[][]{
                {new RegistrationTestData()
                        .withLogin(USER_LOGIN)
                        .withPassword(USER_PASSWORD)
                        .withFirstName("firstName")
                        .withSecondName("secondName")
                        .withBirthYear(2000)
                        .withBirthMonth(Month.JANUARY)
                        .withBirthDay(Day.MONDAY)
                        .withPhone("+38-063-111-11-11")
                        .withEmail("me@gmail.com")
                        .withCity("Lviv")
                        .withGender(Gender.MALE)
                        .createDTO()
                        .shouldPass(true)
                        .withExpectedHTTPCode(200)}
        };
    }

    @Test(dataProvider = REGISTER_DATA_PROVIDER)
    public void registrationTest(RegistrationTestData registration) {
        ResponseDTO response = registrationController.register(registration.getRegistration());

        assertEquals(response.getResponseCode(), registration.getExpectedHttpCode());

        if (!registration.isPositive()) {
            assertEquals(registration.getExpectedErrorMessage(), response.getErrorMessage());
        }
    }
}
