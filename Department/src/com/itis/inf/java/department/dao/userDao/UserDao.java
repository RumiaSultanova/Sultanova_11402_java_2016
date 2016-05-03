package com.itis.inf.java.department.dao.userDao;

import com.itis.inf.java.department.dao.models.User;

/**
 * Created by rumia on 04/05/16.
 */
public interface UserDao {
    User getUser(int id);
    boolean addUser(User user);
}
