package com.se.sample.booksmanagement.repository;

/**
 * @author Evgeniy Skiba on 11.11.2020
 * @project books-management
 */

import com.se.sample.booksmanagement.model.Role;
import com.se.sample.booksmanagement.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}