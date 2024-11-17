package com.cmgg.toy.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public Response<Void> handleRuntimeException(RuntimeException e) {
        return Response.fail(e.getMessage());
    }
}
