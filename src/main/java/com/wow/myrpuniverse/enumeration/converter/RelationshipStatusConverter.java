package com.wow.myrpuniverse.enumeration.converter;

import com.wow.myrpuniverse.enumeration.RelationshipStatusEnum;

import javax.persistence.AttributeConverter;
import java.util.Objects;

public class RelationshipStatusConverter implements AttributeConverter<RelationshipStatusEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RelationshipStatusEnum value) {
        Integer cod = null;

        if (Objects.isNull(value)) {
            return RelationshipStatusEnum.UNKNOWN.getCod();
        }

        for (RelationshipStatusEnum e : RelationshipStatusEnum.values()) {
            if (e.equals(value)) {
                cod = e.getCod();
            }
        }

        return cod;
    }

    @Override
    public RelationshipStatusEnum convertToEntityAttribute(Integer value) {
        RelationshipStatusEnum enumValue = null;

        if (Objects.isNull(value)) {
            return RelationshipStatusEnum.UNKNOWN;
        }

        for (RelationshipStatusEnum e : RelationshipStatusEnum.values()) {
            if (e.getCod().equals(value)) {
                enumValue = e;
            }
        }
        return enumValue;
    }
}
