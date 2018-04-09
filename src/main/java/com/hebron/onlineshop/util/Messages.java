package com.hebron.onlineshop.util;

public class Messages {

    public static final String SUCCESS = "Operation was successful";
    public static final String ERROR = "Unable to perform operation";

    private static final String BAD_CREDENTIALS = "You have provided bad login [%1$s] or password [%2$s], check your credentials and try again";

    public static String badCredentialsMessage(String login, String password) {
        return String.format(BAD_CREDENTIALS, login, password);
    }
}
