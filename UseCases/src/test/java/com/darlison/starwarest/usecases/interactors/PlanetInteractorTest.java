package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.usecases.gateways.PlanetGateway;
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
public class PlanetInteractorTest {

    private final PlanetInteractor interactor;

    public PlanetInteractorTest() {
        interactor = new PlanetInteractor();
        interactor.gateway = mock(PlanetGateway.class);
    }

    @Test
    public void testList() {
        List<Planet> expected = List.of(new Planet(1L), new Planet(2L));
        when(interactor.gateway.list(null)).thenReturn(expected);
        List<Planet> result = interactor.list(null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString())).thenReturn(expected);
        List<Planet> result2 = interactor.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Planet expected = new Planet(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Planet result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Planet result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
