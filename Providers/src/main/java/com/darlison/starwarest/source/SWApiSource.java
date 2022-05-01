package com.darlison.starwarest.source;

import org.springframework.web.client.RestTemplate;


public class SWApiSource {

    public static final String API_SOURCE = "https://swapi.dev/api";

    public static final RestTemplate source = new RestTemplate();

    public static String makeRequest(String uri) {
        return makeRequest(uri, String.class);
    }

    public static <T> T makeRequest(String uri, Class<T> type, Object... params) {
        return source.getForObject(uri, type, params);
    }

}
