package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Specie;
import com.darlison.starwarest.usecases.gateways.SpecieGateway;
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
public class SpecieInteractorTest {

    private final SpecieInteractor interactor;

    public SpecieInteractorTest() {
        interactor = new SpecieInteractor();
        interactor.gateway = mock(SpecieGateway.class);
    }

    @Test
    public void testList() {
        List<Specie> expected = List.of(new Specie(1L), new Specie(2L));
        when(interactor.gateway.list(null)).thenReturn(expected);
        List<Specie> result = interactor.list(null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString())).thenReturn(expected);
        List<Specie> result2 = interactor.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Specie expected = new Specie(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Specie result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Specie result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
