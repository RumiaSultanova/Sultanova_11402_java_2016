package com.itis.inf.java.department.services;

import com.itis.inf.java.department.dao.models.User;
import com.itis.inf.java.department.dao.userDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by rumia on 04/05/16.
 */
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao dao;

    @Override
    public User getUserById(int ID) {
        return dao.getUser(ID);
    }

    @Override
    public User getUserByMail(String mail) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        dao.addUser(user);
        return true;
    }
}
