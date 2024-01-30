package com.example.EmployeeManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepositoryInterface extends JpaRepository<Employee, Long>{
    
}
