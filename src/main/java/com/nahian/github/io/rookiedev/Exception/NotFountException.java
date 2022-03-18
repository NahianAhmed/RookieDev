package com.nahian.github.io.rookiedev.Exception;


public class NotFountException extends RuntimeException {

    private static final long serialVersionUID = 7199841501797573515L;

    public NotFountException() {
        super("NOT FOUND");
    }

    public NotFountException(String ex) {
        super(ex);
    }

}
