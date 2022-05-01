package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.*;
import com.darlison.starwarest.model.PersonModel;
import com.darlison.starwarest.request.PersonRequest;
import com.darlison.starwarest.source.ApiSource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PersonGatewayImplTest {

    private final PersonGatewayImpl gateway;

    public PersonGatewayImplTest() {
        gateway = new PersonGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        PersonRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, PersonRequest.class, ""))
                .thenReturn(expected);
        List<Person> result = gateway.list("");
        List<Person> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            comparePersons(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        PersonModel expectedModel = mockModel(id);
        Person expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, PersonModel.class))
                .thenReturn(expectedModel);
        Person result = gateway.getOne((long) id);
        comparePersons(result, expected);
    }

    private void comparePersons(Person r, Person e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getBirthYear(), e.getBirthYear());
        assertEquals(r.getEyeColor(), e.getEyeColor());
        assertEquals(r.getGender(), e.getGender());
        assertEquals(r.getHairColor(), e.getHairColor());
        assertEquals(r.getHeight(), e.getHeight());
        assertEquals(r.getMass(), e.getMass());
        assertEquals(r.getSkinColor(), e.getSkinColor());
        assertEquals(r.getHomeworld(), e.getHomeworld());
        assertEquals(r.getFilms(), e.getFilms());
        assertEquals(r.getSpecies(), e.getSpecies());
        assertEquals(r.getVehicles(), e.getVehicles());
        assertEquals(r.getStarships(), e.getStarships());
    }

    private PersonRequest mockRequest() {
        PersonRequest request = new PersonRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private PersonModel mockModel(int id) {
        return new PersonModel(
                "Luke Skywalker",
                "19BBY",
                "blue",
                "male",
                "blond",
                "172",
                "77",
                "fair",
                "planets/1",
                List.of("films/1"),
                Collections.emptyList(),
                List.of("vehicles/14/", "vehicles/30/"),
                List.of("starships/12/"),
                "2014-12-09T13:50:51",
                "2014-12-20T21:17:56",
                "https://swapi.dev/api/people/"+ id +"/"
        );
    }

    private Person mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Person(
                id,
                "Luke Skywalker",
                "19BBY",
                "blue",
                "male",
                "blond",
                "172",
                "77",
                "fair",
                new Planet(1L),
                List.of(new Film(1L)),
                Collections.emptyList(),
                List.of(new Vehicle(14L), new Vehicle(30L)),
                List.of(new Starship(12L)),
                formatter.parse("2014-12-09T13:50:51"),
                formatter.parse("2014-12-20T21:17:56")
        );
    }

}
