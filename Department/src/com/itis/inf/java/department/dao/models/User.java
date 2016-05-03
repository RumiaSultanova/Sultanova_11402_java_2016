package com.itis.inf.java.department.dao.models;

/**
 * Created by rumia on 03/05/16.
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private int companyID;

    public User(int id, String name, String surname, int companyID) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.companyID = companyID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
