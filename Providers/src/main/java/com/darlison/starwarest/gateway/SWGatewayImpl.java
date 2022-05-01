package com.darlison.starwarest.gateway;


import com.darlison.starwarest.model.BaseModel;
import com.darlison.starwarest.source.SWApiSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SWGatewayImpl {

    protected String url;

    protected static final Logger logger = LoggerFactory.getLogger(SWGatewayImpl.class);

    SWGatewayImpl(String url) {
        this.url = SWApiSource.API_SOURCE + url;
    }

    public String addParam(String param, String value, char separator) {
        return (value == null || value.trim().isEmpty())
                ? ""
                : separator + param + "={" + param + "}";
    }

    public boolean isStringEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

}
