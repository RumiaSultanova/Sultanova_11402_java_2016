package com.itis.inf.java.department.exceptions;

/**
 * Created by rumia on 03/05/16.
 */
public class CompanyNotFoundException extends RuntimeException {
    String temp;
    public CompanyNotFoundException(int id) {
        temp = "No such company " + id;
    }

    public CompanyNotFoundException(String name) {
        temp = "No such company " + name;
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
