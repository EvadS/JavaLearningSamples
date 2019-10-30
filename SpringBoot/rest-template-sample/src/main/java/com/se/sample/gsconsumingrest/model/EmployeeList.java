package com.se.sample.gsconsumingrest.model;

import com.se.sample.gsconsumingrest.controller.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {
    private List<Employee> employees;

    public EmployeeList() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
