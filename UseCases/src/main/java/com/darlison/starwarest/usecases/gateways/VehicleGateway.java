package com.darlison.starwarest.usecases.gateways;

import com.darlison.starwarest.entities.Vehicle;

import java.util.List;

public interface VehicleGateway extends SWGateway<Vehicle> {

    List<Vehicle> list(String param1, String param2);

}
