package com.se.example.springbootjavah2.service;

import com.se.example.springbootjavah2.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
