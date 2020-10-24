package com.productpickerservicepoc.exception;

public class BadRequestException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public BadRequestException(final String code, final String message) {
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
