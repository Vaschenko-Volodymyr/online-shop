package com.hebron.onlineshop.util;

public class Messages {

    public static final String SUCCESS = "Operation was successful";
    public static final String ERROR = "Unable to perform operation";

    private static final String CHECK_YOURSELF = "Check your input and try again";

    private static final String BAD_CREDENTIALS = "You have provided bad login [%1$s] or password [%2$s], " +
            "reason: %3$s. " + CHECK_YOURSELF;
    private static final String BAD_REGISTRATION_INFO = "You have provided incorrect registration information. %1$s. " + CHECK_YOURSELF;

    public static String badCredentialsMessage(String login, String password, String reason) {
        return String.format(BAD_CREDENTIALS, login, password, reason);
    }

    public static String badRegistrationInfo(String reason) {
        return String.format(BAD_REGISTRATION_INFO, reason);
    }
}
