package com.darlison.starwarest.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertSame;

public class VehicleTest {

    @Test
    public void test() throws ParseException {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Vehicle vehicle = new Vehicle(
            1L,
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
            dateFormatter.parse("2014-12-10T15:36:25"),
            dateFormatter.parse("2014-12-10T15:36:25")
        );

        assertSame(1L, vehicle.getId());
        assertSame("Sand Crawler", vehicle.getName());
        assertSame("Digger Crawler", vehicle.getModel());
        assertSame("wheeled", vehicle.getVehicleClass());
        assertSame("Corellia Mining Corporation", vehicle.getManufacturer());
        assertSame("36.8", vehicle.getLength());
        assertSame("150000", vehicle.getCostInCredits());
        assertSame("46", vehicle.getCrew());
        assertSame("30", vehicle.getPassengers());
        assertSame("30", vehicle.getMaxAtmospheringSpeed());
        assertSame("50000", vehicle.getCargoCapacity());
        assertSame("2 months", vehicle.getConsumables());
        Assertions.assertEquals(List.of(new Film(1L)), vehicle.getFilms());
        Assertions.assertEquals(Collections.emptyList(), vehicle.getPilots());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T15:36:25"), vehicle.getCreated());
        Assertions.assertEquals(dateFormatter.parse("2014-12-10T15:36:25"), vehicle.getEdited());
    }
}
