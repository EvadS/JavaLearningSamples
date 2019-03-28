package com.se.example.springboot_validation.repository;

import com.se.example.springboot_validation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByName(String name);

    public List<Employee> findAll();

}