package com.alexluta.ainetworkassistant.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Builder;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {
        ErrorResponse body =  ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode("USER_NOT_FOUND")
                .errorMessage(ex.getMessage())
                .timestamp(Instant.now())
                .path(request.getServletPath())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateUser(DuplicateResourceException ex, HttpServletRequest request) {
        ErrorResponse body = ErrorResponse.builder()
                .status(HttpStatus.CONFLICT.value())
                .errorCode("USER_ALREADY_EXISTS")
                .errorMessage(ex.getMessage())
                .timestamp(Instant.now())
                .path(request.getServletPath())
                .build();

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(UserNotFoundByEmailException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundByEmail(UserNotFoundByEmailException ex, HttpServletRequest request){
        ErrorResponse body = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode("USER_NOT_FOUND_BY_EMAIL")
                .errorMessage(ex.getMessage())
                .timestamp(Instant.now())
                .path(request.getServletPath())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(UserNotFoundByUsernameException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundByUsername(UserNotFoundByUsernameException ex, HttpServletRequest request){
        ErrorResponse body = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode("USER_NOT_FOUND_BY_USERNAME")
                .errorMessage(ex.getMessage())
                .timestamp(Instant.now())
                .path(request.getServletPath())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(UserNotFoundByPhoneNumberException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundByPhoneNumber(UserNotFoundByPhoneNumberException ex, HttpServletRequest request){
        ErrorResponse body = ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .errorCode("USER_NOT_FOUND_BY_PHONE_NUMBER")
                .errorMessage(ex.getMessage())
                .timestamp(Instant.now())
                .path(request.getServletPath())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}
