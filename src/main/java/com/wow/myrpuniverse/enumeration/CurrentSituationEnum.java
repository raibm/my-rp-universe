package com.wow.myrpuniverse.enumeration;

import lombok.Getter;

@Getter
public enum CurrentSituationEnum {
    DEAD(0),
    ALIVE(1),
    DISAPPEARED(2),
    ARRESTED(3),
    UNKNOWN(4);

    private final Integer cod;

    CurrentSituationEnum(Integer cod) {
        this.cod = cod;
    }

    public Integer getCod(){
        return this.cod;
    }


}
