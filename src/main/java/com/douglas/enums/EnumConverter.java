package com.douglas.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EnumConverter<T extends Enum<T> & BaseEnum<E>, E> implements AttributeConverter<T,E>{

    private final Class<T> type;

    public EnumConverter(Class<T> type){
        this.type = type;
    }

    @Override
    public E convertToDatabaseColumn(T attribute) {
        return attribute != null ? attribute.getId() : null;
    }

    @Override
    public T convertToEntityAttribute(E dbData) {
        T[] enums = type.getEnumConstants();

        for (T t : enums) {
            if (t.getId().equals(dbData)) {
                return t;
            }
        }
        throw new UnsupportedOperationException();
    }


}
