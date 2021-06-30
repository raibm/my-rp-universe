package com.wow.myrpuniverse.enumeration.converter;

import com.wow.myrpuniverse.enumeration.CurrentSituationEnum;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class CurrentSituationConverter implements AttributeConverter<CurrentSituationEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CurrentSituationEnum value) {
        Integer cod = null;

        if (Objects.isNull(value)) {
            return CurrentSituationEnum.UNKNOWN.getCod();
        }

        for (CurrentSituationEnum e : CurrentSituationEnum.values()) {
            if (e.equals(value)) {
                cod = e.getCod();
            }
        }

        return cod;
    }

    @Override
    public CurrentSituationEnum convertToEntityAttribute(Integer value) {
        CurrentSituationEnum enumValue = null;

        if (Objects.isNull(value)) {
            return CurrentSituationEnum.UNKNOWN;
        }

        for (CurrentSituationEnum e : CurrentSituationEnum.values()) {
            if (e.getCod().equals(value)) {
                enumValue = e;
            }
        }
        return enumValue;
    }
}
