package com.darlison.starwarest.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExceptionBean {

    private Date date;
    private String message;
    private String description;
}
