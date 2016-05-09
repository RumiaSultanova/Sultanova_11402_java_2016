package com.itis.inf.java.department.controllers.dto;

import com.itis.inf.java.department.dao.models.User;

/**
 * Created by rumia on 04/05/16.
 */
public class UserDto {
    private int id;
    private String name;
    private String surname;
    private String company;

    public UserDto(User user) {
        this.id = user.getID();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.company = user.getCompany();
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
