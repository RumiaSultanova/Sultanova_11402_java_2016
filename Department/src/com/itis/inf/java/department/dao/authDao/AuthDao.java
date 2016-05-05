package com.itis.inf.java.department.dao.authDao;

import com.itis.inf.java.department.dao.models.Auth;

/**
 * Created by rumia on 04/05/16.
 */
public interface AuthDao {
    Auth getAuth(int id);
    boolean addAuth(Auth auth);
}
