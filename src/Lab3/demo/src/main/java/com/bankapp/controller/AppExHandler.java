package com.bankapp.controller;

import com.bankapp.dto.ErrorDetailsDto;
import com.bankapp.exceptions.AccountNotFoundException;
import com.bankapp.exceptions.InsufficientFundsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class AppExHandler {
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorDetailsDto> handle404(AccountNotFoundException ex) {
        ErrorDetailsDto errorDetails=
                ErrorDetailsDto.builder().errorCode(404)
                        .timestamp(java.time.LocalDateTime.now())
                        .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<ErrorDetailsDto> handle500(InsufficientFundsException ex) {
        ErrorDetailsDto errorDetails=
                ErrorDetailsDto.builder().errorCode(500)
                        .timestamp(java.time.LocalDateTime.now())
                        .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetailsDto> handle400(MethodArgumentNotValidException ex) {
        String errorMessage= ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(e->e.getDefaultMessage())
                .collect(Collectors.joining(", "));


        ErrorDetailsDto errorDetails=
                ErrorDetailsDto.builder().errorCode(400)
                        .timestamp(java.time.LocalDateTime.now())
                        .errorMessage(errorMessage).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetailsDto> handle500(Exception ex){
        ErrorDetailsDto errorDetails=
                ErrorDetailsDto.builder().errorCode(500)
                        .timestamp(java.time.LocalDateTime.now())
                        .errorMessage(ex.getMessage()).build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }
}
