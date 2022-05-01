package com.darlison.starwarest.model;

import com.darlison.starwarest.entities.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.ParseException;
import java.util.Date;

import static com.darlison.starwarest.util.DateHelper.parseDate;
import static com.darlison.starwarest.util.UrlHelper.extractIdFromUrl;

@Getter
@NoArgsConstructor
public abstract class BaseModel {

    private String created;
    private String edited;
    private String url;

    public BaseModel(
            String created,
            String edited,
            String url
    ) {
        this.created = created;
        this.edited = edited;
        this.url = url;
    }

    protected void setEntityValues(BaseEntity entity) {
        entity.setCreated(parseDate(this.created));
        entity.setEdited(parseDate(this.created));
        entity.setId(extractIdFromUrl(this.url));
    }

}
