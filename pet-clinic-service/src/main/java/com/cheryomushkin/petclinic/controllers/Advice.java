package com.cheryomushkin.petclinic.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class Advice {
    @ExceptionHandler
    public void catchNoSuchElement(NoSuchElementException exception, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
        log.warn("element not found", exception);
    }
}
