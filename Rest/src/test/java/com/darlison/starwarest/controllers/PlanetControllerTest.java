package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Planet;
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
public class PlanetControllerTest {

    final PlanetController controller;

    public PlanetControllerTest() {
        controller = new PlanetController();
        controller.boundary = mock(SWBoundary.class);
    }

    @Test
    public void testList() {
        List<Planet> expected = List.of(new Planet(1L), new Planet(2L));
        when(controller.boundary.list(null)).thenReturn(expected);
        List<Planet> result = controller.list(null);
        assertEquals(expected, result);

        when(controller.boundary.list(anyString())).thenReturn(expected);
        List<Planet> result2 = controller.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Planet expected = new Planet(3L);
        when(controller.boundary.getById(3L)).thenReturn(expected);
        Planet result = controller.get(3L);
        assertEquals(expected, result);

        when(controller.boundary.getById(1L)).thenReturn(null);
        Planet result2 = controller.get(1L);
        assertNull(result2);

    }


}
