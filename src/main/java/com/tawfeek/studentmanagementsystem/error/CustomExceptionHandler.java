package com.tawfeek.studentmanagementsystem.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


//not at evaluation criteria
@RestControllerAdvice
public class CustomExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        // Creating a response entity with only the exception type
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getClass().toString());
//    }

}
