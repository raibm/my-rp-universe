package com.wow.myrpuniverse.enumeration;

import lombok.Getter;

@Getter
public enum CurrentSituationEnum {
    DEAD(0, "Dead"),
    ALIVE(1, "Alive"),
    UNKNOWN(4, "Unknown");

    private final Integer cod;
    private final String description;

    CurrentSituationEnum(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod(){
        return this.cod;
    }


}
