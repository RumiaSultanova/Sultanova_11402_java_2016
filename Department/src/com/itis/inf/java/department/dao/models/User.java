package com.itis.inf.java.department.dao.models;

import com.itis.inf.java.department.controllers.dto.UserDto;

/**
 * Created by rumia on 03/05/16.
 */
public class User {
    private int id;
    private String name;
    private String surname;
    private String company;

    public User(int id, String name, String surname, String company) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCompany() {
        return company;
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

    public void setCompany(String company) {
        this.company = company;
    }
}
