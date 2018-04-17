package com.hebron.onlineshop.util;

import com.hebron.onlineshop.dto.AuthorizationDTO;
import com.hebron.onlineshop.dto.RegistrationDTO;
import lombok.Getter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final String EMPTY_FIELD = "Empty %1$s field";
    private static final String INCORRECT_EMAIL = "Your email did not match pattern: [text]@[text].[domain]";
    private static final String INCORRECT_PHONE = "Your phone did not match pattern: +[code][operator][identifiers]. " +
            "Example: +1-111-111-1111";

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_PHONE_NUMBER =
            Pattern.compile("\\+\\d{2}-\\d{3}-\\d{3}-\\d{2}-\\d{2}");

    @Getter
    public static class ValidationResult {

        private boolean isValid;
        private String reason;

        ValidationResult() {
            this.isValid = false;
        }
    }

    public static ValidationResult validateLoginCredentials(AuthorizationDTO authorization) {
        ValidationResult validationResult = new ValidationResult();
        String login = authorization.getLogin();
        String password = authorization.getPassword();

        if (login == null || login.equals("")) {
            validationResult.reason = emptyField("login");
            return validationResult;
        }

        if (password == null || password.equals("")) {
            validationResult.reason = emptyField("password");
            return validationResult;
        }

        validationResult.isValid = true;
        return validationResult;
    }

    public static ValidationResult validateRegistration(RegistrationDTO registration) {
        ValidationResult validationResult = new ValidationResult();
        String firstName = registration.getFirstName();
        String secondName = registration.getSecondName();

        if (firstName == null || firstName.equals("")) {
            validationResult.reason = emptyField("first name");
            return validationResult;
        }

        if (secondName == null || secondName.equals("")) {
            validationResult.reason = emptyField("second name");
            return validationResult;
        }

        String email = registration.getEmail();
        if (email == null || !validateEmail(email)) {
            validationResult.reason = INCORRECT_EMAIL;
            return validationResult;
        }

        String phone = registration.getPhone();
        if (phone == null || !validatePhone(phone)) {
            validationResult.reason = INCORRECT_PHONE;
            return validationResult;
        }

        validationResult.isValid = true;
        return validationResult;
    }

    /**
     * Visible for testing reasons
     * @param fieldName name of parameter which is empty
     * @return concatenated error message
     */
    public static String emptyField(String fieldName) {
        return String.format(EMPTY_FIELD, fieldName);
    }

    private static boolean validateEmail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

    private static boolean validatePhone(String phone) {
        Matcher matcher = VALID_PHONE_NUMBER.matcher(phone);
        return matcher.find();
    }
}
