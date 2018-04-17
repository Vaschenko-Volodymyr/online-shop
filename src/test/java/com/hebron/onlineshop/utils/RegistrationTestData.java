package com.hebron.onlineshop.utils;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.RegistrationDTO;
import com.hebron.onlineshop.dto.utils.DataDTO;
import com.hebron.onlineshop.util.units.Day;
import com.hebron.onlineshop.util.units.Gender;
import com.hebron.onlineshop.util.units.Month;
import lombok.Getter;

public class RegistrationTestData extends TestData {

    @Getter
    private RegistrationDTO registration = new RegistrationDTO();

    private AuthorizationDTO authorization;
    private DataDTO data;

    public RegistrationTestData withLogin(String login) {
        initAuthorization();
        authorization.setLogin(login);
        return this;
    }

    public RegistrationTestData withPassword(String password) {
        initAuthorization();
        authorization.setPassword(password);
        return this;
    }

    public RegistrationTestData withFirstName(String firstName) {
        registration.setFirstName(firstName);
        return this;
    }

    public RegistrationTestData withSecondName(String secondName) {
        registration.setSecondName(secondName);
        return this;
    }

    public RegistrationTestData withBirthYear(int year) {
        initData();
        data.setYear(year);
        return this;
    }

    public RegistrationTestData withBirthMonth(Month month) {
        initData();
        data.setMonth(month);
        return this;
    }

    public RegistrationTestData withBirthDay(Day day) {
        initData();
        data.setDay(day);
        return this;
    }

    public RegistrationTestData withPhone(String phone) {
        registration.setPhone(phone);
        return this;
    }

    public RegistrationTestData withCity(String city) {
        registration.setCity(city);
        return this;
    }

    public RegistrationTestData withEmail(String email) {
        registration.setEmail(email);
        return this;
    }

    public RegistrationTestData withGender(Gender gender) {
        registration.setGender(gender);
        return this;
    }

    public RegistrationTestData createDTO() {
        registration.setAuthorization(authorization);
        registration.setBirth(data);
        return this;
    }

    private void initData() {
        if (this.data == null) {
            data = new DataDTO();
        }
    }

    private void initAuthorization() {
        if (this.authorization == null) {
            authorization = new AuthorizationDTO();
        }
    }
}
