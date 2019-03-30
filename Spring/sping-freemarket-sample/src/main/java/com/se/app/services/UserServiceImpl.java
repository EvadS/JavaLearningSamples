package com.se.app.services;

import com.se.app.dao.UserDao;
import com.se.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.ApplicationException;
import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    public UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void save(User user) {
        if(user.getAge()<2)
            throw new RuntimeException ("Age should be  gress 2 year");

        userDao.save(user);
    }


    public User getById(int id) {
        return userDao.getById(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }
}
