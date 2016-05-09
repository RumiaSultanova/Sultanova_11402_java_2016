package com.itis.inf.java.department.controllers.dto;

import com.itis.inf.java.department.dao.models.Company;

/**
 * Created by rumia on 09/05/16.
 */
public class CompanyDto {
    private int ID;
    private String name;
    private String address;
    private String admin;
    private String worker;

    public CompanyDto(Company company) {
        this.ID = company.getID();
        this.name = company.getName();
        this.address = company.getAddress();
        this.admin = company.getAdmin();
        this.worker = company.getWorker();
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
