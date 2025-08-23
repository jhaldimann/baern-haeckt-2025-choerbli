package org.choerbli.mapper;

import org.choerbli.controller.dto.ChoerbliStateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChoerbliStateMapper {
    default ChoerbliStateDto toChoerbliStateDto(int state) {
        return ChoerbliStateDto.fromState(state);
    }

    default int toChoerbliState(ChoerbliStateDto stateDto) {
        return stateDto.getState();
    }
}
