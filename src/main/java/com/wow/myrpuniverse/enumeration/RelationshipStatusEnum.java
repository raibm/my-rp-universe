package com.wow.myrpuniverse.enumeration;

import lombok.Getter;

@Getter
public enum RelationshipStatusEnum {
    SINGLE(0, "Single"),
    MARRIED(1, "Married"),
    ENGAGED(2, "Engaged"),
    IN_A_RELATIONSHIP(3, "In a relationship"),
    WIDOWED(4, "Widowed"),
    UNKNOWN(5, "Unknown");

    private final Integer cod;
    private final String description;

    RelationshipStatusEnum(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod(){
        return this.cod;
    }


}
