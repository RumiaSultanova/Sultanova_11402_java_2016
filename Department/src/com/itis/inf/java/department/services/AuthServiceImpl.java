package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.authDao.AuthDao;
import com.itis.inf.java.department.dao.models.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by rumia on 09/05/16.
 */
@Component
public class AuthServiceImpl implements AuthService{
    @Autowired
    private AuthDao authDao;

    @Override
    public boolean addAuth(Auth auth) {
        authDao.addAuth(auth);
        return true;
    }

    @Override
    public Auth getAuth(int ID) {
        return authDao.getAuth(ID);
    }

    @Override
    public Auth getAuth(String mail) {
        return authDao.getAuth(mail);
    }
}
