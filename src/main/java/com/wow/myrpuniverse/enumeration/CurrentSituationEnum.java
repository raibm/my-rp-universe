package com.wow.myrpuniverse.enumeration;

import lombok.Getter;

@Getter
public enum CurrentSituationEnum {
    DEAD(0),
    ALIVE(1),
    DISAPPEARED(2),
    ARRESTED(3);

    private Integer cod;

    CurrentSituationEnum(Integer cod) {
        this.cod = cod;
    }
}
