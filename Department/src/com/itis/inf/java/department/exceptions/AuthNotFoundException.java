package com.itis.inf.java.department.exceptions;

/**
 * Created by rumia on 09/05/16.
 */
public class AuthNotFoundException extends RuntimeException {
    String temp;
    public AuthNotFoundException(int id) {
        temp = "No such auth " + id;
    }
    public AuthNotFoundException(String mail) {
        temp = "No such auth " + mail;
    }

    @Override
    public String getMessage() {
        return temp;
    }

    @Override
    public String getLocalizedMessage() {
        return temp;
    }

    @Override
    public String toString() {
        return temp;
    }
}
