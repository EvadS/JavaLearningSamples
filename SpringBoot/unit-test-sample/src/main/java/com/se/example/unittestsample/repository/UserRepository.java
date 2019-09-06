package com.se.example.unittestsample.repository;

import com.se.example.unittestsample.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
