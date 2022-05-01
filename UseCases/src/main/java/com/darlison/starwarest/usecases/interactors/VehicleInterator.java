package com.darlison.starwarest.usecases.interactors;

import com.darlison.starwarest.entities.Vehicle;
import com.darlison.starwarest.usecases.boundaries.SWBoundary;
import com.darlison.starwarest.usecases.gateways.VehicleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleInterator implements SWBoundary<Vehicle> {

    @Autowired
    private VehicleGateway gateway;

    @Override
    public List<Vehicle> list(String param1) {
        return this.list(param1, null);
    }

    @Override
    public List<Vehicle> list(String param1, String param2) {
        return gateway.list(param1, param2);
    }

    @Override
    public Vehicle getById(Long id) {
        return gateway.getOne(id);
    }
}
