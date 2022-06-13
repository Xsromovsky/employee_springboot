package com.example.springboot.employee_springboot.services;

import com.example.springboot.employee_springboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    //rr

    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);


    Employee updateEmployee(long empId, Employee employee);

    Employee deleteEmployee(long empId);
}
