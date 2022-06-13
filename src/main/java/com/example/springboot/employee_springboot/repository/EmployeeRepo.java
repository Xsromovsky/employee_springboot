package com.example.springboot.employee_springboot.repository;

import com.example.springboot.employee_springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepo extends JpaRepository<Employee, Long> {


}

