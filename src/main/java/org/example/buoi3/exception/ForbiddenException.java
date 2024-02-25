package org.example.buoi3.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends RuntimeException{
    private HttpStatus status;

    public ForbiddenException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
