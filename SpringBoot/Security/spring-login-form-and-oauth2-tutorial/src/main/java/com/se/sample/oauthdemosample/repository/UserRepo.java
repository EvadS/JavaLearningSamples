package com.se.sample.oauthdemosample.repository;

import com.se.sample.oauthdemosample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
