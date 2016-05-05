package com.itis.inf.java.department.dao.models;

import java.util.Objects;

/**
 * Created by rumia on 03/05/16.
 */
public class Auth {
    private int id;
    private String mail;
    private String password;

    public Auth(int id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
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

    public boolean equals(Object object){
        if (null == object || this.getClass() != object.getClass()){
            return false;
        }else {
            Auth temp = (Auth) object;
            return Objects.equals(this.getId(), temp.getId()) &&
                    Objects.equals(this.getMail(), temp.getMail()) &&
                    Objects.equals(this.getPassword(), temp.getPassword());
        }
    }
}
