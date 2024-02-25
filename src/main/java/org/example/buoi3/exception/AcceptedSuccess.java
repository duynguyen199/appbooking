package org.example.buoi3.exception;

import org.springframework.http.HttpStatus;

public class AcceptedSuccess extends RuntimeException{

    private HttpStatus httpStatus;

    public AcceptedSuccess(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
