package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.models.Auth;

/**
 * Created by rumia on 04/05/16.
 */
public interface AuthService {
    boolean addAuth(Auth auth);
    Auth getAuth(int ID);
    Auth getAuth(String mail);
}
