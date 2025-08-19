package com.tli.consumer.exceptions;

public class UnprocessableEntityException extends RuntimeException {
    public UnprocessableEntityException() {
        super("Unprocessable Entity Exception");
    }
}
