package com.se.example.springboot_validation.services;

import com.se.example.springboot_validation.entities.Employee;

import java.util.List;

public interface EmployeeService {
     public Employee getEmployeeById(Long id);

     public Employee getEmployeeByName(String name);

     public List<Employee> getAllEmployees();

     public boolean exists(String email);

     public Employee save(Employee employee);
}
