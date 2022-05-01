package com.darlison.starwarest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {

    private Long id;
    private Date created;
    private Date edited;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public BaseEntity(
            Long id,
            Date created,
            Date edited
    ) {
        this(id);
        this.created = created;
        this.edited = edited;
    }

}
