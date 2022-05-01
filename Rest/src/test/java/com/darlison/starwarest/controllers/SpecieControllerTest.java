package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Specie;
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
public class SpecieControllerTest {

    final SpecieController controller;

    public SpecieControllerTest() {
        controller = new SpecieController();
        controller.boundary = mock(SWBoundary.class);
    }
    @Test
    public void testList() {
        List<Specie> expected = List.of(new Specie(1L), new Specie(2L));
        when(controller.boundary.list(null)).thenReturn(expected);
        List<Specie> result = controller.list(null);
        assertEquals(expected, result);

        when(controller.boundary.list(anyString())).thenReturn(expected);
        List<Specie> result2 = controller.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Specie expected = new Specie(3L);
        when(controller.boundary.getById(3L)).thenReturn(expected);
        Specie result = controller.get(3L);
        assertEquals(expected, result);

        when(controller.boundary.getById(1L)).thenReturn(null);
        Specie result2 = controller.get(1L);
        assertNull(result2);

    }


}
