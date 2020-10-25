package com.productservicepoc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public BadRequestException(final String code, final String message) {
        super(message);
        this.errorCode = code;
        this.errorMessage = message;
    }
}
