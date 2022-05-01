package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.entities.Film;
import com.darlison.starwarest.model.FilmModel;
import com.darlison.starwarest.model.FilmModel;
import com.darlison.starwarest.model.VehicleModel;
import com.darlison.starwarest.request.FilmRequest;
import com.darlison.starwarest.request.FilmRequest;
import com.darlison.starwarest.request.StarshipRequest;
import com.darlison.starwarest.source.SWApiSource;
import com.darlison.starwarest.usecases.gateways.FilmGateway;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmGatewayImpl extends SWGatewayImpl implements FilmGateway {

    public FilmGatewayImpl() {
        super("/films");
    }

    @Override
    public List<Film> list(String name) {
        final String url = this.url + addParam("name", name, '?');
        final FilmRequest result = SWApiSource.makeRequest(url, FilmRequest.class, name);
        return result == null
                ? Collections.emptyList()
                : result.getResults()
                .stream()
                .map(FilmModel::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Film getOne(Long id) {
        return SWApiSource.makeRequest(this.url + '/' + id, FilmModel.class).toEntity();
    }
}

