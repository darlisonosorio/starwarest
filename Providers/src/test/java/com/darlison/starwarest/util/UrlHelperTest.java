package com.darlison.starwarest.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UrlHelperTest {

    @Test
    public void testUrlHelper() {
        Long id = UrlHelper.extractIdFromUrl("https://swapi.dev/api/planets/3/");
        assertEquals(3L, id);
    }

    @Test
    public void testInvalidUrlHelper() {
        Long id = UrlHelper.extractIdFromUrl("https://swapi.dev/api/planets//");
        assertNull(id);
    }

    @Test
    public void testNullUrlHelper() {
        Long id = UrlHelper.extractIdFromUrl(null);
        assertNull(id);
    }
}
