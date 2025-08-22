package org.choerbli.handler.port;

import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.request.UserCreationDto;

import java.util.UUID;

public interface UserPort {
    UserDto getById(UUID id);

    UserDto create(UserCreationDto creationDto);
}
