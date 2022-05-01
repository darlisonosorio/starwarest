package com.darlison.starwarest.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiSource {

    private static final Logger logger = LoggerFactory.getLogger(ApiSource.class);

    public static final String API_SOURCE = "https://swapi.dev/api";

    public static RestTemplate source = new RestTemplate();

    public static String makeRequest(String uri) {
        return makeRequest(uri, String.class);
    }

    public static <T> T makeRequest(String uri, Class<T> type, Object... params) {
        logger.info("EXTERNAL URL: " + uri);

        T result = source.getForObject(uri, type, params);

        logger.info("RESULT: " + result);

        return result;
    }

}
