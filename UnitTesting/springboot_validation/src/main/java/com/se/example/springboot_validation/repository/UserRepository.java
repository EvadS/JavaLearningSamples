package com.se.example.springboot_validation.repository;

import com.se.example.springboot_validation.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}