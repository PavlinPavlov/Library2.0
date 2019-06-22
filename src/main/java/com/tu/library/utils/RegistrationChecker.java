package com.tu.library.utils;

public class RegistrationChecker {

    public static boolean validate(String username, String password) {
        if (username == null || password == null)
            return false;

        if (username.trim().length() < 3 || password.trim().length() < 6)
            return false;

        return true;
    }
}
