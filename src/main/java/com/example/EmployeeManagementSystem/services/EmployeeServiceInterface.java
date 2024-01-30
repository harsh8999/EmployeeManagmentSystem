package com.example.EmployeeManagementSystem.services;

import java.util.List;

import com.example.EmployeeManagementSystem.entity.Designation;
import com.example.EmployeeManagementSystem.entity.Employee;

/**
 * Service interface for managing employee-related operations.
 */
public interface EmployeeServiceInterface {

    /**
     * Retrieve all employees.
     *
     * @return A list of all employees.
     */
    List<Employee> getAllEmployees();
    
    /**
     * Retrieve an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID, or null if not found.
     */
    Employee getEmployee(Long id);

    /**
     * Add a new employee with the given name and designation.
     *
     * @param name        The name of the new employee.
     * @param designation The designation of the new employee.
     * @return The newly created employee.
     */
    Employee addEmployee(String name, Designation designation);

    /**
     * Update the details of an existing employee.
     *
     * @param id The ID of the employee to update.
     * @param employee The employee of the employee to update.
     * @return The updated employee.
     */
    Employee updateEmployeeDetails(Long id, Employee employee);

    /**
     * Delete an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     */
    void deleteEmployee(Long id);

}
