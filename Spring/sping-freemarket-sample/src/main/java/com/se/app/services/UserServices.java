package com.se.app.services;

import com.se.app.entity.User;

import java.util.List;

public interface UserServices {

    List<User> findAll();

    void save(User user);

    User getById(int id);

    void update(User user);

    void delete (int id);
}
