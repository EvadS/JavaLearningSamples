package com.se.app.dao;

import com.se.app.entity.User;
import com.se.app.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl  implements  UserDao{

    public final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> findAll() {
        String sql = "Select * FROM vebinar.USER";
        return jdbcTemplate.query(sql, new UserMapper());
    }


    public void save(User user) {
        String sql = "INSERT INTO vebinar.user (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge());

    }


    public User getById(int id) {
        String sql = "SELECT * FROM vebinar.user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new UserMapper(),id);
    }

    public void update(User user) {
        String sql = "UPDATE vebinar.user SET name=?, email=?, age=? WHERE id=?";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getAge(), user.getId());
    }



    public void delete(int id) {
        String sql = "DELETE FROM vebinar.user WHERE id=?;";
        jdbcTemplate.update(sql,id);

    }
}