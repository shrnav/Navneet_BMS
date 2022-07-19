package com.navneet.learning.bms.bmsapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BMSExceptionController {
    @ExceptionHandler(value = TheatreNotFoundException.class)
    public ResponseEntity<Object> exception(TheatreNotFoundException exception) {
        return new ResponseEntity<>("Theatre not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = NoSuchElementExistsException.class)
    public ResponseEntity<Object> exception(NoSuchElementExistsException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ElementAlreadyExistException.class)
    public ResponseEntity<Object> exception(ElementAlreadyExistException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
