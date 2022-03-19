package com.nahian.github.io.rookiedev.Exception;

import com.nahian.github.io.rookiedev.Objects.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFountException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFountException exception) {
        return new ResponseEntity<>(new ApiError(exception.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleUserCreationException(UserException exception) {
        return new ResponseEntity<>( new ApiError(exception.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now()), HttpStatus.BAD_REQUEST);
    }

}
