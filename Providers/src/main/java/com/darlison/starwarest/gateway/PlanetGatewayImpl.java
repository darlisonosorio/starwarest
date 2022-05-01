package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Planet;
import com.darlison.starwarest.model.PlanetModel;
import com.darlison.starwarest.request.PersonRequest;
import com.darlison.starwarest.request.PlanetRequest;
import com.darlison.starwarest.source.SWApiSource;
import com.darlison.starwarest.usecases.gateways.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlanetGatewayImpl extends SWGatewayImpl implements PlanetGateway {

    public PlanetGatewayImpl() {
        super("/planets");
    }

    @Override
    public List<Planet> list(String name) {
        final String url = this.url + addParam("name", name, '?');
        final PlanetRequest result = SWApiSource.makeRequest(url, PlanetRequest.class, name);
        return result == null
            ? Collections.emptyList()
            : result.getResults()
                     .stream()
                     .map(PlanetModel::toEntity)
                     .collect(Collectors.toList());
    }

    @Override
    public Planet getOne(Long id) {
        return SWApiSource.makeRequest(this.url + '/' + id, PlanetModel.class).toEntity();
    }
}
