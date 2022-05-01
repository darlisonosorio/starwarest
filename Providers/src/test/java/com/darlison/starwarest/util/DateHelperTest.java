package com.darlison.starwarest.util;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DateHelperTest {

    @Test
    public void testDateParse() {
        Date date = DateHelper.parseDate("2014-12-10T16:36:50");
        assertEquals(2014, date.getYear()+1900);
        assertEquals(12, date.getMonth()+1);
        assertEquals(10, date.getDate());
        assertEquals(16, date.getHours());
        assertEquals(36, date.getMinutes());
        assertEquals(50, date.getSeconds());
    }

    @Test
    public void testDateParseWithCustomParser() {
        Date date = DateHelper.parseDate("2014-12-10T16:36:50", new SimpleDateFormat("yyyy-MM-dd"));
        assertEquals(2014, date.getYear()+1900);
        assertEquals(12, date.getMonth()+1);
        assertEquals(10, date.getDate());
        assertEquals(0, date.getHours());
        assertEquals(0, date.getMinutes());
        assertEquals(0, date.getSeconds());
    }

    @Test
    public void testInvalidDateParse() {
        Date date = DateHelper.parseDate("20141210T16:36:50");
        assertNull(date);
    }

    @Test
    public void testNullDateParse() {
        Date date = DateHelper.parseDate(null);
        assertNull(date);
    }

}
