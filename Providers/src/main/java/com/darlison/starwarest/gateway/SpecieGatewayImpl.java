package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Specie;
import com.darlison.starwarest.model.SpecieModel;
import com.darlison.starwarest.request.SpecieRequest;
import com.darlison.starwarest.source.ApiSource;
import com.darlison.starwarest.usecases.gateways.SpecieGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpecieGatewayImpl extends SWGatewayImpl implements SpecieGateway {

    public SpecieGatewayImpl() {
        super("/species");
    }

    @Override
    public List<Specie> list(String name) {
        final String url = this.url + addParam("name", name, '?');
        final SpecieRequest result = ApiSource.makeRequest(url, SpecieRequest.class, name);

        logger.info(result.toString());

        return result.getResults()
                .stream()
                .map(SpecieModel::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Specie getOne(Long id) {
        return ApiSource.makeRequest(this.url + '/' + id, SpecieModel.class).toEntity();
    }
}
