package com.hebron.onlineshop.util;

public class Messages {

    private static final String CHECK_YOURSELF = "Check your input and try again";

    public static final String SUCCESS = "Operation was successful";
    public static final String ERROR = "Unable to perform operation";
    public static final String NOT_IMPLEMENTED = "Could not perform operation because this is not implemented yet";

    public static final String WRONG_CREDENTIALS = "Wrong login or password. " + CHECK_YOURSELF;

    private static final String BAD_CREDENTIALS = "You have provided bad credentials. %1$s. " + CHECK_YOURSELF;
    private static final String BAD_REGISTRATION_INFO = "You have provided incorrect registration information. " +
            "%1$s. " + CHECK_YOURSELF;

    public static String badCredentialsMessage(String reason) {
        return String.format(BAD_CREDENTIALS, reason);
    }

    public static String badRegistrationInfo(String reason) {
        return String.format(BAD_REGISTRATION_INFO, reason);
    }
}
