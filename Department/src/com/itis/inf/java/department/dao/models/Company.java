package com.itis.inf.java.department.dao.models;

/**
 * Created by rumia on 09/05/16.
 */
public class Company {
    private int ID;
    private String name;
    private String address;
    private String admin;
    private String worker;

    public Company(int ID, String name, String address, String admin, String worker) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.admin = admin;
        this.worker = worker;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getAdmin() {
        return admin;
    }

    public String getWorker() {
        return worker;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }
}
