package com.wow.myrpuniverse.enumeration.converter;

import com.wow.myrpuniverse.enumeration.CurrentSituationEnum;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class CurrentSituationConverter implements AttributeConverter<CurrentSituationEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CurrentSituationEnum value) {
        Integer currentSituationCod = null;

        if (Objects.isNull(value)) {
            return CurrentSituationEnum.UNKNOWN.getCod();
        }

        for (CurrentSituationEnum e : CurrentSituationEnum.values()) {
            if (e.equals(value)) {
                currentSituationCod = e.getCod();
            }
        }

        return currentSituationCod;
    }

    @Override
    public CurrentSituationEnum convertToEntityAttribute(Integer value) {
        CurrentSituationEnum currentSituationEnum = null;

        if (Objects.isNull(value)) {
            return CurrentSituationEnum.UNKNOWN;
        }

        for (CurrentSituationEnum e : CurrentSituationEnum.values()) {
            if (e.getCod().equals(value)) {
                currentSituationEnum = e;
            }
        }
        return currentSituationEnum;
    }
}
