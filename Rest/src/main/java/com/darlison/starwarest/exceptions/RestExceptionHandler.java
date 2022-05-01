package com.darlison.starwarest.exceptions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(HttpClientErrorException.class)
    public final ResponseEntity handleHttpClientExceptions(HttpClientErrorException ex, WebRequest request) {
        ExceptionBean exceptionBean = new ExceptionBean(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));

        LOGGER.error(ex.getMessage(), ex);

        return new ResponseEntity<>(exceptionBean, ex.getStatusCode());
    }

}
