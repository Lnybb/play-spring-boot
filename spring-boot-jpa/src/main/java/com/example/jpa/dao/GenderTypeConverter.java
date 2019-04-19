package com.example.jpa.dao;

import javax.persistence.AttributeConverter;

/**
 * @author zyd
 * @date 2019/04/18
 */
public class GenderTypeConverter implements AttributeConverter<GenderType, String> {
    @Override
    public String convertToDatabaseColumn(GenderType genderType) {
        return genderType.getCode();
    }

    @Override
    public GenderType convertToEntityAttribute(String dbData) {
        return GenderType.getByCode(dbData);
    }
}
