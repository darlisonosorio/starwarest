package com.darlison.starwarest.gateway;

import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.entities.Person;
import com.darlison.starwarest.model.PersonModel;
import com.darlison.starwarest.model.PersonModel;
import com.darlison.starwarest.request.PersonRequest;
import com.darlison.starwarest.request.PersonRequest;
import com.darlison.starwarest.request.VehicleRequest;
import com.darlison.starwarest.source.SWApiSource;
import com.darlison.starwarest.usecases.gateways.PersonGateway;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonGatewayImpl extends SWGatewayImpl implements PersonGateway {

    public PersonGatewayImpl() {
        super("/people");
    }

    @Override
    public List<Person> list(String name) {
        final String url = this.url + addParam("name", name, '?');
        final PersonRequest result = SWApiSource.makeRequest(url, PersonRequest.class, name);
        return result == null
                ? Collections.emptyList()
                : result.getResults()
                .stream()
                .map(PersonModel::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Person getOne(Long id) {
        return SWApiSource.makeRequest(this.url + '/' + id, PersonModel.class).toEntity();
    }
}
