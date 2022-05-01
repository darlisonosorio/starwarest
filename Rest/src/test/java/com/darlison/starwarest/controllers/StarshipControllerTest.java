package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Starship;
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
public class StarshipControllerTest {

    final StarshipController controller;

    public StarshipControllerTest() {
        controller = new StarshipController();
        controller.boundary = mock(SWBoundary.class);
    }

    @Test
    public void testList() {
        List<Starship> expected = List.of(new Starship(1L), new Starship(2L));
        when(controller.boundary.list(null, null)).thenReturn(expected);
        List<Starship> result = controller.list(null, null);
        assertEquals(expected, result);


        when(controller.boundary.list(anyString(), anyString())).thenReturn(expected);
        List<Starship> result2 = controller.list("bac", "abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Starship expected = new Starship(3L);
        when(controller.boundary.getById(3L)).thenReturn(expected);
        Starship result = controller.get(3L);
        assertEquals(expected, result);

        when(controller.boundary.getById(1L)).thenReturn(null);
        Starship result2 = controller.get(1L);
        assertNull(result2);

    }


}
