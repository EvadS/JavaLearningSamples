package net.proselite.spring.security.app.dao;

import net.proselite.spring.security.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
