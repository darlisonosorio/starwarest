package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.*;
import com.darlison.starwarest.model.PlanetModel;
import com.darlison.starwarest.request.PlanetRequest;
import com.darlison.starwarest.source.ApiSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanetGatewayImplTest {

    private final PlanetGatewayImpl gateway;

    public PlanetGatewayImplTest() {
        gateway = new PlanetGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        PlanetRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, PlanetRequest.class, ""))
                .thenReturn(expected);
        List<Planet> result = gateway.list("");
        List<Planet> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            comparePlanets(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        PlanetModel expectedModel = mockModel(id);
        Planet expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, PlanetModel.class))
                .thenReturn(expectedModel);
        Planet result = gateway.getOne((long) id);
        comparePlanets(result, expected);
    }

    private void comparePlanets(Planet r, Planet e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getDiameter(), e.getDiameter());
        assertEquals(r.getRotationPeriod(), e.getRotationPeriod());
        assertEquals(r.getOrbitalPeriod(), e.getOrbitalPeriod());
        assertEquals(r.getGravity(), e.getGravity());
        assertEquals(r.getPopulation(), e.getPopulation());
        assertEquals(r.getClimate(), e.getClimate());
        assertEquals(r.getTerrain(), e.getTerrain());
        assertEquals(r.getSurfaceWater(), e.getSurfaceWater());
        assertEquals(r.getFilms(), e.getFilms());
        assertEquals(r.getResidents(), e.getResidents());
    }

    private PlanetRequest mockRequest() {
        PlanetRequest request = new PlanetRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private PlanetModel mockModel(int id) {
        return new PlanetModel(
                "Tatooine",
                "10465",
                "23",
                "304",
                "1",
                "120000",
                "Arid",
                "Dessert",
                "1",
                List.of("films/1/"),
                List.of("people/1/"),
                "2014-12-09T13:50:49",
                "2014-12-15T13:48:16",
                "https://swapi.dev/api/planets/"+ id + "/"
        );
    }

    private Planet mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Planet(
                id,
                "Tatooine",
                "10465",
                "23",
                "304",
                "1",
                "120000",
                "Arid",
                "Dessert",
                "1",
                List.of(new Film(1L)),
                List.of(new Person(1L)),
                formatter.parse("2014-12-09T13:50:49"),
                formatter.parse("2014-12-15T13:48:16")
        );
    }

}
