package com.hebron.onlineshop.mocks.repository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractUserRepoMock {

    static Set<String> logins = new HashSet<>();
    static Set<String> passwords = new HashSet<>();

    public static void addLogin(String login) {
        logins.add(login);
    }

    public static void addPassword(String password) {
        passwords.add(password);
    }

    public static void reset() {
        logins = new HashSet<>();
        passwords = new HashSet<>();
    }
}
