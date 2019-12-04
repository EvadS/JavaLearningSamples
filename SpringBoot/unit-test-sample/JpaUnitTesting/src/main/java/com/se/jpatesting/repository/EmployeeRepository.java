package com.se.jpatesting.repository;

import com.se.jpatesting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
     Employee findByName(String name);
}
