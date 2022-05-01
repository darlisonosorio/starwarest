package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.usecases.gateways.PersonGateway;
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
public class PersonInteractorTest {

    private final PersonInteractor interactor;

    public PersonInteractorTest() {
        interactor = new PersonInteractor();
        interactor.gateway = mock(PersonGateway.class);
    }

    @Test
    public void testList() {
        List<Person> expected = List.of(new Person(1L), new Person(2L));
        when(interactor.gateway.list(null)).thenReturn(expected);
        List<Person> result = interactor.list(null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString())).thenReturn(expected);
        List<Person> result2 = interactor.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Person expected = new Person(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Person result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Person result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
