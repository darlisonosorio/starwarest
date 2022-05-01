package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.usecases.gateways.StarshipGateway;
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
public class StarshipInteractorTest {

    private final StarshipInteractor interactor;

    public StarshipInteractorTest() {
        interactor = new StarshipInteractor();
        interactor.gateway = mock(StarshipGateway.class);
    }

    @Test
    public void testList() {
        List<Starship> expected = List.of(new Starship(1L), new Starship(2L));
        when(interactor.gateway.list(null, null)).thenReturn(expected);
        List<Starship> result = interactor.list(null, null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString(), anyString())).thenReturn(expected);
        List<Starship> result2 = interactor.list("abc", "cba");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Starship expected = new Starship(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Starship result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Starship result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
