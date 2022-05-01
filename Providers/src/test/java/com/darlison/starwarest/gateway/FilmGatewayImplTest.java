package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.*;
import com.darlison.starwarest.model.FilmModel;
import com.darlison.starwarest.request.FilmRequest;
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
public class FilmGatewayImplTest {

    private final FilmGatewayImpl gateway;

    public FilmGatewayImplTest() {
        gateway = new FilmGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        FilmRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, FilmRequest.class, ""))
                .thenReturn(expected);
        List<Film> result = gateway.list("");
        List<Film> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            compareFilms(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        FilmModel expectedModel = mockModel(id);
        Film expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, FilmModel.class))
                .thenReturn(expectedModel);
        Film result = gateway.getOne((long) id);
        compareFilms(result, expected);
    }

    private void compareFilms(Film r, Film e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getTitle(), e.getTitle());
        assertEquals(r.getPlanets(), e.getPlanets());
        assertEquals(r.getCharacters(), e.getCharacters());
        assertEquals(r.getStarships(), e.getStarships());
        assertEquals(r.getSpecies(), e.getSpecies());
        assertEquals(r.getDirector(), e.getDirector());
        assertEquals(r.getEpisodeId(), e.getEpisodeId());
        assertEquals(r.getOpeningCrawl(), e.getOpeningCrawl());
        assertEquals(r.getProducer(), e.getProducer());
    }

    private FilmRequest mockRequest() {
        FilmRequest request = new FilmRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private FilmModel mockModel(int id) {
        return new FilmModel(
                "A New Hope",
                4,
                "It is a period of civil war.",
                "George Lucas",
                "Gary Kurtz, Rick McCallum",
                "1977-05-25T00:00:00",
                List.of("/species/1/"),
                List.of("starships/2/"),
                List.of("people/1/"),
                List.of("planets/1/"),
                "2014-12-10T14:23:31",
                "2014-12-12T11:24:39",
                "https://swapi.dev/api/films/" + id + "/"
        );
    }

    private Film mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Film(
                id,
                "A New Hope",
                4,
                "It is a period of civil war.",
                "George Lucas",
                "Gary Kurtz, Rick McCallum",
                formatter.parse("1977-05-25T00:00:00"),
                List.of(new Specie(1L)),
                List.of(new Starship(2L)),
                List.of(new Person(1L)),
                List.of(new Planet(1L)),
                formatter.parse("2014-12-10T14:23:31"),
                formatter.parse("2014-12-12T11:24:39")
        );
    }

}
