package com.darlison.starwarest.source;

import com.darlison.starwarest.entities.Film;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiSourceTest {

    @Test
    public void testApiSourceRequest() {
        ApiSource.source = mock(RestTemplate.class);
        String expected = "Resposta do servico";
        String request = "/request/url";
        when(ApiSource.source.getForObject(request, String.class))
                .thenReturn(expected);
        String result = ApiSource.makeRequest(request);
        assertEquals(expected, result);
    }


    @Test
    public void testApiSourceRequestWithCustomResult() {
        ApiSource.source = mock(RestTemplate.class);
        Film expected = new Film(1L);
        String request = "/request/url";
        when(ApiSource.source.getForObject(request, Film.class))
                .thenReturn(expected);
        Film result = ApiSource.makeRequest(request, Film.class);
        assertEquals(expected, result);
    }
}
