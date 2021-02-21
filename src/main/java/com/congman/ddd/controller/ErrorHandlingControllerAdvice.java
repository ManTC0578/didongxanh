package com.congman.ddd.controller;

import com.congman.ddd.common.enums.ErrorCode;
import com.congman.ddd.dto.ErrorDTO;
import com.congman.ddd.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException exception, WebRequest request) {
        ErrorDTO errorDTO = ErrorDTO.build().withCode(ErrorCode.RESOURCE_NOT_FOUND)
                .withMessage(exception.getMessage())
                .withException(exception)
                .withPath(request.getContextPath())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
    }
}
