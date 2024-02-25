package org.example.buoi3.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    private HttpStatus status;

    public NotFoundException(String message) {
        super(message);
    }

}
