package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Vehicle;
import com.darlison.starwarest.usecases.gateways.VehicleGateway;
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
public class VehicleInteractorTest {

    private final VehicleInteractor interactor;

    public VehicleInteractorTest() {
        interactor = new VehicleInteractor();
        interactor.gateway = mock(VehicleGateway.class);
    }

    @Test
    public void testList() {
        List<Vehicle> expected = List.of(new Vehicle(1L), new Vehicle(2L));
        when(interactor.gateway.list(null, null)).thenReturn(expected);
        List<Vehicle> result = interactor.list(null, null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString(), anyString())).thenReturn(expected);
        List<Vehicle> result2 = interactor.list("abc", "cba");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Vehicle expected = new Vehicle(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Vehicle result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Vehicle result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
