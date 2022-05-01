package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.model.StarshipModel;
import com.darlison.starwarest.request.StarshipRequest;
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
public class StarshipGatewayImplTest {

    private final StarshipGatewayImpl gateway;

    public StarshipGatewayImplTest() {
        gateway = new StarshipGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        StarshipRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, StarshipRequest.class, "", ""))
                .thenReturn(expected);
        List<Starship> result = gateway.list("", "");
        List<Starship> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            compareStarships(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        StarshipModel expectedModel = mockModel(id);
        Starship expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, StarshipModel.class))
                .thenReturn(expectedModel);
        Starship result = gateway.getOne((long) id);
        compareStarships(result, expected);
    }

    private void compareStarships(Starship r, Starship e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getModel(), e.getModel());
        assertEquals(r.getStarshipClass(), e.getStarshipClass());
        assertEquals(r.getManufacturer(), e.getManufacturer());
        assertEquals(r.getCostInCredits(), e.getCostInCredits());
        assertEquals(r.getLength(), e.getLength());
        assertEquals(r.getCrew(), e.getCrew());
        assertEquals(r.getPassengers(), e.getPassengers());
        assertEquals(r.getMaxAtmospheringSpeed(), e.getMaxAtmospheringSpeed());
        assertEquals(r.getHyperdriveRating(), e.getHyperdriveRating());
        assertEquals(r.getMGLT(), e.getMGLT());
        assertEquals(r.getCargoCapacity(), e.getCargoCapacity());
        assertEquals(r.getConsumables(), e.getConsumables());
        assertEquals(r.getPilots(), e.getPilots());
        assertEquals(r.getFilms(), e.getFilms());
    }

    private StarshipRequest mockRequest() {
        StarshipRequest request = new StarshipRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private StarshipModel mockModel(int id) {
        return new StarshipModel(
                "Death Star",
                "DS-1 Orbital Battle Station",
                "Deep Space Mobile Battlestation",
                "Imperial Department of Military Research, Sienar Fleet Systems",
                "1000000000000",
                "120000",
                "342953",
                "843342",
                "n/a",
                "4.0",
                "10 MGLT",
                "1000000000000",
                "3 years",
                Collections.emptyList(),
                List.of("films/1/"),
                "2014-12-10T16:36:50",
                "2014-12-10T16:36:50",
                "https://swapi.dev/api/starships/" + id + "/"
        );
    }

    private Starship mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Starship(
                id,
                "Death Star",
                "DS-1 Orbital Battle Station",
                "Deep Space Mobile Battlestation",
                "Imperial Department of Military Research, Sienar Fleet Systems",
                "1000000000000",
                "120000",
                "342953",
                "843342",
                "n/a",
                "4.0",
                "10 MGLT",
                "1000000000000",
                "3 years",
                Collections.emptyList(),
                List.of(new Film(1L)),
                formatter.parse("2014-12-10T16:36:50"),
                formatter.parse("2014-12-10T16:36:50")
        );
    }

}
