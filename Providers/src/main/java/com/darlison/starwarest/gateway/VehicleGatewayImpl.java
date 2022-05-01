package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Vehicle;
import com.darlison.starwarest.model.VehicleModel;
import com.darlison.starwarest.request.VehicleRequest;
import com.darlison.starwarest.source.ApiSource;
import com.darlison.starwarest.usecases.gateways.VehicleGateway;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class VehicleGatewayImpl extends SWGatewayImpl implements VehicleGateway {

    public VehicleGatewayImpl() {
        super("/vehicles");
    }

    @Override
    public List<Vehicle> list(String search) {
        return this.list(search, null);
    }

    @Override
    public List<Vehicle> list(String name, String model) {
        final String nameParam = addParam("name", name, '?');
        final String modelParam = addParam("model", model, nameParam.isEmpty() ? '?' : '&');
        final String url = this.url + nameParam + modelParam;

        final VehicleRequest result = ApiSource.makeRequest(url, VehicleRequest.class, name, model);

        return result == null
                ? Collections.emptyList()
                : result.getResults()
                .stream()
                .map(VehicleModel::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Vehicle getOne(Long id) {
        return ApiSource.makeRequest(this.url + '/' + id, VehicleModel.class).toEntity();
    }
}