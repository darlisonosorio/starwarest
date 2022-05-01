package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Vehicle;
import com.darlison.starwarest.model.VehicleModel;
import com.darlison.starwarest.request.VehicleRequest;
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
public class VehicleGatewayImplTest {

    private final VehicleGatewayImpl gateway;

    public VehicleGatewayImplTest() {
        gateway = new VehicleGatewayImpl();
        ApiSource.source = mock(RestTemplate.class);
    }

    @Test
    public void testList() throws ParseException {
        VehicleRequest expected = mockRequest();
        when(ApiSource.source.getForObject(gateway.url, VehicleRequest.class, "", ""))
                .thenReturn(expected);
        List<Vehicle> result = gateway.list("", "");
        List<Vehicle> expectedList = List.of(mockEntity(1L), mockEntity(2L));

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++) {
            compareVehicles(result.get(i), expectedList.get(i));
        }
    }

    @Test
    public void getOne() throws ParseException {
        int id = 10;
        VehicleModel expectedModel = mockModel(id);
        Vehicle expected = mockEntity((long) id);
        when(ApiSource.source.getForObject(gateway.url + '/' + id, VehicleModel.class))
                .thenReturn(expectedModel);
        Vehicle result = gateway.getOne((long) id);
        compareVehicles(result, expected);
    }

    private void compareVehicles(Vehicle r, Vehicle e) {
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getModel(), e.getModel());
        assertEquals(r.getVehicleClass(), e.getVehicleClass());
        assertEquals(r.getManufacturer(), e.getManufacturer());
        assertEquals(r.getCostInCredits(), e.getCostInCredits());
        assertEquals(r.getLength(), e.getLength());
        assertEquals(r.getCrew(), e.getCrew());
        assertEquals(r.getPassengers(), e.getPassengers());
        assertEquals(r.getMaxAtmospheringSpeed(), e.getMaxAtmospheringSpeed());
        assertEquals(r.getCargoCapacity(), e.getCargoCapacity());
        assertEquals(r.getConsumables(), e.getConsumables());
        assertEquals(r.getPilots(), e.getPilots());
        assertEquals(r.getFilms(), e.getFilms());
    }

    private VehicleRequest mockRequest() {
        VehicleRequest request = new VehicleRequest();
        request.setCount(2);
        request.setResults(List.of(mockModel(1), mockModel(2)));
        return request;
    }

    private VehicleModel mockModel(int id) {
        return new VehicleModel(
            "Sand Crawler",
            "Digger Crawler",
            "wheeled",
            "Corellia Mining Corporation",
            "36.8",
            "150000",
            "46",
            "30",
            "30",
            "50000",
            "2 months",
            List.of("films/1/"),
            Collections.emptyList(),
            "2014-12-10T15:36:25",
            "2014-12-10T15:36:25",
            "https://swapi.dev/api/vehicles/" + id + "/"
        );
    }

    private Vehicle mockEntity(Long id) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return new Vehicle(
            id,
            "Sand Crawler",
            "Digger Crawler",
            "wheeled",
            "Corellia Mining Corporation",
            "36.8",
            "150000",
            "46",
            "30",
            "30",
            "50000",
            "2 months",
            List.of(new Film(1L)),
            Collections.emptyList(),
            formatter.parse("2014-12-10T15:36:25"),
            formatter.parse("2014-12-10T15:36:25")
        );
    }

}
