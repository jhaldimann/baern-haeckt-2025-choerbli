package org.choerbli.mapper;

import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.ChoerbliStateDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.model.Choerbli;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ChoerbliStateMapper.class, ConsequenceTypeMapper.class})
public interface ChoerbliMapper {
    ChoerbliDto toChoerbliDto(final Choerbli choerbli);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "state", ignore = true)
    Choerbli toChoerbli(final ChoerbliCreationDto choerbliCreationDto);
}
