package com.darlison.starwarest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public abstract class BaseEntity {

    private Long id;
    private Date created;
    private Date edited;
    private String url;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(
            Long id,
            Date created,
            Date edited,
            String url
    ) {
        this(id);
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

}
