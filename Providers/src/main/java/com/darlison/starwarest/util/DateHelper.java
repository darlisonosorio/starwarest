package com.darlison.starwarest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

    private static final Logger logger = LoggerFactory.getLogger(DateHelper.class);

    private static final SimpleDateFormat defaultFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static Date parseDate(String value) {
        return parseDate(value, defaultFormatter);
    }

    public static Date parseDate(String value, SimpleDateFormat formatter) {
        Date result = null;
        try {
            result = formatter.parse(value);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
