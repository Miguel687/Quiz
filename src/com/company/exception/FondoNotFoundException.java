package com.company.exception;

public class FondoNotFoundException extends Exception {
    public FondoNotFoundException() {
    }

    public FondoNotFoundException(String message) {
        super(message);
    }
}
