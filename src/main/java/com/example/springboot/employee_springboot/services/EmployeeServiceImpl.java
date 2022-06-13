package com.example.springboot.employee_springboot.services;


import com.example.springboot.employee_springboot.exception.ResourceNotFoundException;
import com.example.springboot.employee_springboot.model.Employee;
import com.example.springboot.employee_springboot.repository.EmployeeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // This is a service class
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw  new ResourceNotFoundException("Employee", "id", id);
        }
    }

    @Override
    public Employee updateEmployee(long empId, Employee employee) {
        return employeeRepo.findById(empId)
                .map(emp -> {
                    emp.setFirstName(employee.getFirstName());
                    emp.setLastName(employee.getLastName());
                    emp.setEmail(employee.getEmail());
                    return employeeRepo.save(emp);
                }).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
    }

    @Override
    public Employee deleteEmployee(long empId) {
        return employeeRepo.findById(empId)
                .map(emp -> {
                    employeeRepo.delete(emp);
                    return emp;
                }).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
    }


}
