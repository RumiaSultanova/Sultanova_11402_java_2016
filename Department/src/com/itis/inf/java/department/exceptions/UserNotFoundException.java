package com.itis.inf.java.department.exceptions;

/**
 * Created by rumia on 03/05/16.
 */
public class UserNotFoundException extends RuntimeException {
    String temp;
    public UserNotFoundException(int id) {
        temp = "No such user " + id;
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
