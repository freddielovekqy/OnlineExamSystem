package com.augmentum.oes.exception;

public class DBException extends RuntimeException {

    private static final long serialVersionUID = 3252811664290582444L;

    public DBException(String message) {
        super(message);
    }
}
