package com.nahian.github.io.rookiedev.exception;

import org.springframework.validation.FieldError;


public class UserException extends RuntimeException {

    public UserException(String ex) {
        super(ex);
    }

    public UserException(FieldError exception) {
        super(exception.getField()+ " - " + exception.getDefaultMessage());
    }

}
