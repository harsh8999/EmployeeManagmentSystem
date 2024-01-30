package com.example.EmployeeManagementSystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Designation;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exceptions.ApiException;
import com.example.EmployeeManagementSystem.repositories.EmployeeRepositoryInterface;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepositoryInterface employeeRepositoryInterface;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositoryInterface.findAll();
    }

    @Override
    public Employee getEmployee(Long id) {
        if(id == null) {
            throw new ApiException("ID should not be null !!!");
        }
        Optional<Employee> employee = employeeRepositoryInterface.findById(id);
        // if employee not present throw Exception
        if(!employee.isPresent()) {
            throw new ApiException("Employee with ID: "+ id + " doesn't exists !!!");
        }
        return employee.get();
    }

    @Override
    public Employee addEmployee(String name, Designation designation) {
        Employee employee = new Employee(name, designation);
        Employee savedEmployee = employeeRepositoryInterface.save(employee);
        return savedEmployee;
    }

    @Override
    public Employee updateEmployeeDetails(Long id, Employee employee) {
        if(id == null) {
            throw new ApiException("ID should not be null !!!");
        }

        if(employee == null) {
            throw new ApiException("Employee Details not provided !!!");
        }
        Optional<Employee> optionalEmployee = employeeRepositoryInterface.findById(id);
        // if employee not present throw Exception
        if(!optionalEmployee.isPresent()) {
            throw new ApiException("Employee with ID: "+ id + " doesn't exists !!!");
        }

        // set id as previous
        employee.setId(id);
        
        return employeeRepositoryInterface.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(id == null) {
            throw new ApiException("ID should not be null !!!");
        }

        Optional<Employee> optionalEmployee = employeeRepositoryInterface.findById(id);
        // if employee not present throw Exception
        if(!optionalEmployee.isPresent()) {
            throw new ApiException("Employee with ID: "+ id + " doesn't exists !!!");
        }

        employeeRepositoryInterface.deleteById(id);
    }
    
}
