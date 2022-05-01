package com.darlison.starwarest.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RestExceptionHandlerTest {

    @Test
    public void testHandleHttpClientExceptions() {
        HttpClientErrorException ex = new HttpClientErrorException(
                HttpStatus.NOT_FOUND,
                "message=404 NOT FOUND: \"{\"detail\":\"Not found\"}\""
        );

        WebRequest request = mock(WebRequest.class);
        when(request.getDescription(anyBoolean())).thenReturn("uri=/starships/1");

        RestExceptionHandler handler = new RestExceptionHandler();
        ResponseEntity result = handler.handleHttpClientExceptions(ex, request);
        ExceptionBean resultBody = (ExceptionBean) result.getBody();
        ExceptionBean expected = new ExceptionBean(
                new Date(),
                "404 message=404 NOT FOUND: \"{\"detail\":\"Not found\"}\"",
                "uri=/starships/1"
        );

        assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        assertEquals(expected.getMessage(), resultBody.getMessage());
        assertEquals(expected.getDescription(), resultBody.getDescription());
    }

}
