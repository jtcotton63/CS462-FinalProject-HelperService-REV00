package com.josephee.cs462.user.converter;

import com.josephee.cs462.common.model.user.Role;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Long>  {

    @Override
    public Long convertToDatabaseColumn(Role attribute) {
        return attribute.getId();
    }

    @Override
    public Role convertToEntityAttribute(Long dbData) {
        return Role.from(dbData);
    }
}
