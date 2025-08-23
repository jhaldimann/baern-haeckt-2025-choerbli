package org.choerbli.mapper;

import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.ConsequenceTypeDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.model.Consequence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConsequenceMapper {
    ConsequenceDto toConsequenceDto(final Consequence consequence);

    Consequence toConsequence(final ConsequenceDto consequenceDto);

    @Mapping(target = "choerbli", ignore = true)
    Consequence toConsequence(final ConsequenceCreationDto creationDto);

    default ConsequenceTypeDto map(int type) {
        return ConsequenceTypeDto.fromType(type);
    }

    default int map(ConsequenceTypeDto typeDto) {
        return typeDto.getType();
    }
}
