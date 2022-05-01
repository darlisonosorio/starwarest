package com.darlison.starwarest.controllers;

import com.darlison.starwarest.entities.Person;
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
public class PersonControllerTest {

    final PersonController controller;

    public PersonControllerTest() {
        controller = new PersonController();
        controller.boundary = mock(SWBoundary.class);
    }

    @Test
    public void testList() {
        List<Person> expected = List.of(new Person(1L), new Person(2L));
        when(controller.boundary.list(null)).thenReturn(expected);
        List<Person> result = controller.list(null);
        assertEquals(expected, result);

        when(controller.boundary.list(anyString())).thenReturn(expected);
        List<Person> result2 = controller.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Person expected = new Person(3L);
        when(controller.boundary.getById(3L)).thenReturn(expected);
        Person result = controller.get(3L);
        assertEquals(expected, result);

        when(controller.boundary.getById(1L)).thenReturn(null);
        Person result2 = controller.get(1L);
        assertNull(result2);

    }


}
