package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.entities.Starship;
import com.darlison.starwarest.model.StarshipModel;
import com.darlison.starwarest.model.SpecieModel;
import com.darlison.starwarest.model.StarshipModel;
import com.darlison.starwarest.request.StarshipRequest;
import com.darlison.starwarest.request.SpecieRequest;
import com.darlison.starwarest.request.StarshipRequest;
import com.darlison.starwarest.source.SWApiSource;
import com.darlison.starwarest.usecases.gateways.StarshipGateway;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StarshipGatewayImpl extends SWGatewayImpl implements StarshipGateway {

    public StarshipGatewayImpl() {
        super("/starships");
    }

    @Override
    public List<Starship> list(String search) {
        return this.list(search, null);
    }

    @Override
    public List<Starship> list(String name, String model) {
        final String nameParam = addParam("name", name, '?');
        final String modelParam = addParam("model", model, nameParam.isEmpty() ? '?' : '&');
        final String url = this.url + nameParam + modelParam;

        final StarshipRequest result = SWApiSource.makeRequest(url, StarshipRequest.class, name, model);

        return result == null
                ? Collections.emptyList()
                : result.getResults()
                .stream()
                .map(StarshipModel::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Starship getOne(Long id) {
        return SWApiSource.makeRequest(this.url + '/' + id, StarshipModel.class).toEntity();
    }
}