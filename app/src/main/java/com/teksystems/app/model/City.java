package com.teksystems.app.model;

import java.io.Serializable;

/**
 * Created by sopani on 3/27/2018.
 */

public enum City implements Serializable{
    CITY601("601","HYDERABAD"),
    CITY602 ("602", "SECUNDERABAD"),
    CITY603 ("603","VISHAKAPATNAM"),
    CITY604("604","BENGALURU");
    private final String key;

    private final String value;

    City(String key, String value) {

        this.key = key;

        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
