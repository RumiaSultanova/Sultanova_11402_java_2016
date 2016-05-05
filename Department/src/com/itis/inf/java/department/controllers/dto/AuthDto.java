package com.itis.inf.java.department.controllers.dto;

import com.itis.inf.java.department.dao.models.Auth;

import java.util.Objects;

/**
 * Created by rumia on 04/05/16.
 */
public class AuthDto {
    private int id;
    private String mail;
    private String password;

    public AuthDto(Auth auth) {
        this.id = auth.getId();
        this.mail = auth.getMail();
        this.password = auth.getPassword();
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
