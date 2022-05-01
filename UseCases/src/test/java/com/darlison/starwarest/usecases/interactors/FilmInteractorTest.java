package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.usecases.gateways.FilmGateway;
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
public class FilmInteractorTest {

    private final FilmInteractor interactor;

    public FilmInteractorTest() {
        interactor = new FilmInteractor();
        interactor.gateway = mock(FilmGateway.class);
    }

    @Test
    public void testList() {
        List<Film> expected = List.of(new Film(1L), new Film(2L));
        when(interactor.gateway.list(null)).thenReturn(expected);
        List<Film> result = interactor.list(null);
        assertEquals(expected, result);

        when(interactor.gateway.list(anyString())).thenReturn(expected);
        List<Film> result2 = interactor.list("abc");
        assertEquals(expected, result2);
    }

    @Test
    public void testGet() {
        Film expected = new Film(3L);
        when(interactor.gateway.getOne(3L)).thenReturn(expected);
        Film result = interactor.getById(3L);
        assertEquals(expected, result);

        when(interactor.gateway.getOne(1L)).thenReturn(null);
        Film result2 = interactor.getById(1L);
        assertNull(result2);

    }

}
