package com.empapp.controller;

import com.empapp.dto.EmpDeptDto;
import com.empapp.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //http://localhost:8084/employees/Raj
    @GetMapping("employees/{name}")
    public EmpDeptDto getByName(@PathVariable String name) {
        return employeeService.getByName(name);
    }
}
