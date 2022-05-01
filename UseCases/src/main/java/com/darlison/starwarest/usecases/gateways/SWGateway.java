package com.darlison.starwarest.usecases.gateways;

import java.text.ParseException;
import java.util.List;

public interface SWGateway<T> {

    List<T> list(String search);

    T getOne(Long id);

}
