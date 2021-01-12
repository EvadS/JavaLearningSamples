package com.se.sample.enums;

import java.util.stream.Stream;

/**
 * Monsta attributes to use in template
 */
public enum CommunicationAttributeType {
    LOCATION(0,"Location"),
    DEMOGRAPHIC(1, "Demographic"),
    ATTRIBUTES(2,"Attributes"),
    USER_ATTRIBUTES(3,"User.UserAttributes");

    private int id;
    private String value;

    CommunicationAttributeType(int id, String value) {
        this.id = id;
        this.value =value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public static CommunicationAttributeType of(int id) {
        return Stream.of(CommunicationAttributeType.values())
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
