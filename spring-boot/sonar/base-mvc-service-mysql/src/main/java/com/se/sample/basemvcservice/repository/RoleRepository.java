package com.se.sample.basemvcservice.repository;


import com.se.sample.basemvcservice.model.Role;
import com.se.sample.basemvcservice.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}