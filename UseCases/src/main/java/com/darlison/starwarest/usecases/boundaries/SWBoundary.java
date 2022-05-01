package com.darlison.starwarest.usecases.boundaries;

import java.util.List;

public interface SWBoundary<T> {

    public List<T> list(String param1);

    public List<T> list(String param1, String param2);

    public T getById(Long id);

}
