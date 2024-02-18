package com.sapient.exception;

public class ResourceNotFoundException extends RuntimeException {

    private final int errorCode;

    private String errorMessage;

    public ResourceNotFoundException(String message, Exception cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.errorMessage = message;
    }

    public int getErrorCode(){
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
