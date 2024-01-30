package com.example.EmployeeManagementSystem.exceptions;

/**
 * Custom exception class to represent API-related exceptions for better user Experience
 */
public class ApiException extends RuntimeException {

    public ApiException() {
    }

    public ApiException(String message) {
        super(message);
    }

}
