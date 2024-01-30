package com.example.EmployeeManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.EmployeeManagementSystem.payload.ApiExceptionResponse;

// Global exception handler for handling custom exceptions in the Employee Management System.
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles instances of ApiException and returns a ResponseEntity with an ApiExceptionResponse.
     *
     * @param ex The ApiException that was thrown.
     * @return ResponseEntity containing an ApiExceptionResponse and HTTP status code 400 (BAD_REQUEST).
     */
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiExceptionResponse> ApiExceptionHandler(ApiException ex){
        String message = ex.getMessage();
        ApiExceptionResponse response = new ApiExceptionResponse(message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
