package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FilmControllerTest {

    final FilmController controller;

    public FilmControllerTest() {
        controller = new FilmController();
        controller.boundary = mock(SWBoundary.class);
    }

    @Test
    public void testList() {
        List<Film> expected = List.of(new Film(1L), new Film(2L));
        when(controller.boundary.list(null)).thenReturn(expected);
        List<Film> result = controller.list(null);
        assertEquals(expected, result);

        when(controller.boundary.list(anyString())).thenReturn(expected);
        List<Film> result2 = controller.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Film expected = new Film(3L);
        when(controller.boundary.getById(3L)).thenReturn(expected);
        Film result = controller.get(3L);
        assertEquals(expected, result);

        when(controller.boundary.getById(1L)).thenReturn(null);
        Film result2 = controller.get(1L);
        assertNull(result2);

    }


}
