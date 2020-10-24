package com.productpickerservicepoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserExistsException extends RuntimeException {
    private String errorMessage;

    public UserExistsException(String message) {
        super(message);
        this.errorMessage = message;
    }
}

