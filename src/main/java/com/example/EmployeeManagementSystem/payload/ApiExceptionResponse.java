package com.example.EmployeeManagementSystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a response payload for handling API exceptions.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiExceptionResponse {
    
    /**
     * The message describing the API exception.
     */
    private String message;

}
