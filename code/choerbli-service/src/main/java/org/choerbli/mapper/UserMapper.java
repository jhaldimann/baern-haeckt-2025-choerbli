package org.choerbli.mapper;

import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.UserCreationDto;
import org.choerbli.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ChoerbliStateMapper.class)
public interface UserMapper {
    UserDto toUserDto(final User user);

    User toUser(final UserDto userDto);

    @Mapping(target = "choerbli.id", source = "userCreationDto.choerbliId")
    @Mapping(target = "points", ignore = true)
    User toUser(final UserCreationDto userCreationDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "choerbli", ignore = true)
    @Mapping(target = "name", source = "organizerName")
    @Mapping(target = "email", source = "organizerEmail")
    @Mapping(target = "points", ignore = true)
    User toUser(final ChoerbliCreationDto choerbliCreationDto);
}
