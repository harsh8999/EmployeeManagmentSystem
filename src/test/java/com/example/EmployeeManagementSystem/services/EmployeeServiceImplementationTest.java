package com.example.EmployeeManagementSystem.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.EmployeeManagementSystem.entity.Designation;
import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exceptions.ApiException;
import com.example.EmployeeManagementSystem.repositories.EmployeeRepositoryInterface;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplementationTest {
    
    @Mock
    private EmployeeRepositoryInterface employeeRepository;

    @InjectMocks
    private EmployeeServiceImplementation employeeService;

    @Test
    public void getEmployeeTest() {
            Employee employee = new Employee();
            employee.setId(1L);
            employee.setName("Harsh Nayak");
            employee.setDesignation(Designation.ENGINEER);

            // When calling the mocked repository method
            when(employeeRepository.findAll()).thenReturn(List.of(employee));

            List<Employee> employees = this.employeeService.getAllEmployees();

            assertEquals(List.of(employee), employees);
    }

    @Test
    public void getEmployeeExceptionTest() {

            // When calling the mocked repository method
            when(employeeRepository.findById(2L)).thenThrow(ApiException.class);

            assertThrows(ApiException.class, () -> this.employeeService.getEmployee(2L));

    }

    // @Test
    // public void updateEmployeeTest() {
    //     Employee employee = new Employee();
    //     employee.setId(1L);
    //     employee.setName("Harsh Nayak");
    //     employee.setDesignation(Designation.ENGINEER);

    //     Employee updatedEmp = new Employee();
    //     updatedEmp.setId(1L);
    //     updatedEmp.setName("Harsh Kumar Nayak");
    //     updatedEmp.setDesignation(Designation.ENGINEER);

    //     // When calling the mocked repository methods
    //     when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
    //     when(employeeRepository.save(employee)).thenReturn(updatedEmp);

    //     Employee updatedEmployee = this.employeeService.updateEmployeeDetails(1L, updatedEmp);

    //     assertEquals(employee, updatedEmployee);

    // }

    @Test
    public void updateEmployeeExceptionTest() {
        // When calling the mocked repository methods
        when(employeeRepository.findById(2L)).thenThrow(ApiException.class);

        assertThrows(ApiException.class, () -> this.employeeService.updateEmployeeDetails(2L, new Employee()));
    }
    @Test
    public void deleteEmployeeExceptionTest() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Sahil");
        employee.setDesignation(Designation.ENGINEER);

        // When calling the mocked repository methods
        when(employeeRepository.findById(1L)).thenThrow(ApiException.class);

        assertThrows(ApiException.class, () -> employeeService.deleteEmployee(1L));
    }

}
