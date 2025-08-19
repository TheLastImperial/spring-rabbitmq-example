package com.tli.consumer.api.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tli.consumer.api.models.rs.ErrorRS;
import com.tli.consumer.exceptions.UnprocessableEntityException;

@RestControllerAdvice
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityController {

    @ExceptionHandler(UnprocessableEntityException.class)
    public ErrorRS unprocessableEntity(UnprocessableEntityException ex) {
        return ErrorRS.builder()
            .message(ex.getMessage())
            .status(HttpStatus.UNPROCESSABLE_ENTITY.value())
            .error(HttpStatus.UNPROCESSABLE_ENTITY.name())
            .build();
    }
}
