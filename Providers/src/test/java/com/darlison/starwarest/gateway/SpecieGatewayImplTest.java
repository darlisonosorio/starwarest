package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.entities.Specie;
import com.darlison.starwarest.model.SpecieModel;
import com.darlison.starwarest.request.SpecieRequest;
import com.darlison.starwarest.source.ApiSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpecieGatewayImplTest {

    private final SpecieGatewayImpl gateway;

    public SpecieGatewayImplTest() {
        gateway = new SpecieGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        SpecieRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, SpecieRequest.class, ""))
                .thenReturn(expected);
        List<Specie> result = gateway.list("");
        List<Specie> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            compareSpecies(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        SpecieModel expectedModel = mockModel(id);
        Specie expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, SpecieModel.class))
                .thenReturn(expectedModel);
        Specie result = gateway.getOne((long) id);
        compareSpecies(result, expected);
    }

    private void compareSpecies(Specie r, Specie e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getClassification(), e.getClassification());
        assertEquals(r.getDesignation(), e.getDesignation());
        assertEquals(r.getAverageHeight(), e.getAverageHeight());
        assertEquals(r.getAverageLifespan(), e.getAverageLifespan());
        assertEquals(r.getEyeColors(), e.getEyeColors());
        assertEquals(r.getHairColors(), e.getHairColors());
        assertEquals(r.getSkinColors(), e.getSkinColors());
        assertEquals(r.getLanguage(), e.getLanguage());
        assertEquals(r.getHomeworld(), e.getHomeworld());
        assertEquals(r.getPeople(), e.getPeople());
        assertEquals(r.getFilms(), e.getFilms());
    }

    private SpecieRequest mockRequest() {
        SpecieRequest request = new SpecieRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private SpecieModel mockModel(int id) {
        return new SpecieModel(
                "Wookie",
                "Mammal",
                "Sentient",
                "2.1",
                "400",
                "blue, green, yellow, brown, golden, red",
                "black, brown",
                "gray",
                "Shyriiwook",
                "planets/14/",
                List.of("people/13/"),
                List.of("films/1/", "films/2/"),
                "2014-12-10T16:44:31",
                "2014-12-10T16:44:31",
                "https://swapi.dev/api/species/" + id + "/"
        );
    }

    private Specie mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Specie(
                id,
                "Wookie",
                "Mammal",
                "Sentient",
                "2.1",
                "400",
                "blue, green, yellow, brown, golden, red",
                "black, brown",
                "gray",
                "Shyriiwook",
                new Planet(14L),
                List.of(new Person(13L)),
                List.of(new Film(1L), new Film(2L)),
                formatter.parse("2014-12-10T16:44:31"),
                formatter.parse("2014-12-10T16:44:31")
        );
    }

}
