package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.models.User;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
public interface UserService {
    User getUserById(int id);
    User getUserByMail(String mail);
    List<User> getUsers();
    boolean addUser(User user);
}
