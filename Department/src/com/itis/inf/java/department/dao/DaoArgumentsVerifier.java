package com.itis.inf.java.department.dao;

/**
 * Created by rumia on 5/3/16.
 */
public interface DaoArgumentsVerifier {
    void verifyUser(int ID);
    void verifyUser(String mail);
    void verifyCompany(String name);
    void verifyDoc(int ID);
    void verifyAuth(int ID);
}
