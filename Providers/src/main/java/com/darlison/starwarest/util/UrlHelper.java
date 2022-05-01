package com.darlison.starwarest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlHelper {

    private static final Logger logger = LoggerFactory.getLogger(DateHelper.class);

    public static Long extractIdFromUrl(final String url) {
        if (url == null || url.trim().isEmpty()) return null;
        Long result = null;
        try {
            result = Long.parseLong(url.replaceAll("[^0-9]", ""));
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
