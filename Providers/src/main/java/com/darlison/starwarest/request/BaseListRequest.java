package com.darlison.starwarest.request;

import lombok.Data;

import java.util.List;

@Data
public abstract class BaseListRequest<T> {

    private int count;
    private String next;
    private String previous;
    private List<T> results;

}
