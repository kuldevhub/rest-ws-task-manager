package com.restws.ui.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity NotFound(Exception ex, WebRequest request) {
        log.debug("handling VehicleNotFoundException...");
//        return notFound().build();
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return ResponseEntity.notFound().build();
    }
}
