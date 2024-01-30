package com.example.EmployeeManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.entity.Designation;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exceptions.ApiException;
import com.example.EmployeeManagementSystem.payload.ApiRequest;
import com.example.EmployeeManagementSystem.services.EmployeeServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeServiceInterface employeeService;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody ApiRequest request) {
        if(request == null) {
            throw new ApiException("Employee Details Not Present !!!");
        }
        Employee savedEmployee = employeeService.addEmployee(request.getName(), Designation.valueOf(request.getDesignation()));
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        
    }

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee with "+id+ " deleted...", HttpStatus.OK);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id, @RequestBody  Employee employee) {
        Employee updatedeEployee = employeeService.updateEmployeeDetails(id, employee);
        return new ResponseEntity<>(updatedeEployee, HttpStatus.OK);
    }

}
