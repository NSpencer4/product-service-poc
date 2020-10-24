package com.productpickerservicepoc.exception;


public class NotFoundException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public NotFoundException(final String code, final String message) {
        super(message);
        this.errorCode = code;
        this.errorMessage = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}

