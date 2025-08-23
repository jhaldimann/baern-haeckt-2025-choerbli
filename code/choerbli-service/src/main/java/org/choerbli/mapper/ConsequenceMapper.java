package org.choerbli.mapper;

import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.ConsequenceTypeDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.model.Consequence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ConsequenceTypeMapper.class, ChoerbliStateMapper.class})
public interface ConsequenceMapper {
    ConsequenceDto toConsequenceDto(final Consequence consequence);

    Consequence toConsequence(final ConsequenceDto consequenceDto);

    @Mapping(target = "choerbli", ignore = true)
    Consequence toConsequence(final ConsequenceCreationDto creationDto);
}
