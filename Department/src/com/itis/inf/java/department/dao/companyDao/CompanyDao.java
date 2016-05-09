package com.itis.inf.java.department.dao.companyDao;

import com.itis.inf.java.department.dao.models.Company;

/**
 * Created by rumia on 09/05/16.
 */
public interface CompanyDao {
    Company getCompany(int ID);
    Company getCompany(String name);
    boolean addCompany(Company company);
}
