package com.nahian.github.io.rookiedev.Exception;

import org.springframework.validation.FieldError;


public class UserException extends RuntimeException {

    public UserException(String ex) {
        super(ex);
    }

    public UserException(FieldError exception) {
        super(exception.getField()+ " - " + exception.getDefaultMessage());
    }

}
