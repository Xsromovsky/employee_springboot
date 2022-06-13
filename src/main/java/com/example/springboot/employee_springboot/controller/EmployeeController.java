package com.example.springboot.employee_springboot.controller;

import com.example.springboot.employee_springboot.model.Employee;
import com.example.springboot.employee_springboot.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    //build get all employees REST API
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    //build get employee by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long empId) {
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(empId), HttpStatus.OK);
    }

    //build update employee REST API
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long empId, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmployee(empId, employee), HttpStatus.OK);
    }

    //build delete employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long empId) {
        return new ResponseEntity<Employee>(employeeService.deleteEmployee(empId), HttpStatus.OK);
    }



}
