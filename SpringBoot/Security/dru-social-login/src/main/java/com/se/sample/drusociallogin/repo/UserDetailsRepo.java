package com.se.sample.drusociallogin.repo;

import com.se.sample.drusociallogin.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<User, String> {

}