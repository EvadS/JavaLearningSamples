package net.proselite.spring.security.app.dao;


import net.proselite.spring.security.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}