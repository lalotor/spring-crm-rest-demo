package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

  @ExceptionHandler
  public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
    var error = new CustomerErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exception.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {
    var error = new CustomerErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exception.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
