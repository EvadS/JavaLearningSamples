package com.se.example.sarafan.repo;

import com.se.example.sarafan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User,String> {
}
