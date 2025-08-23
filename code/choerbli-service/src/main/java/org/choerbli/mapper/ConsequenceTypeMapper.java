package org.choerbli.mapper;

import org.choerbli.controller.dto.ConsequenceTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsequenceTypeMapper {

    default ConsequenceTypeDto toConsequenceTypeDto(int type) {
        return ConsequenceTypeDto.fromType(type);
    }

    default int toConsequenceType(ConsequenceTypeDto typeDto) {
        return typeDto.getType();
    }
}
