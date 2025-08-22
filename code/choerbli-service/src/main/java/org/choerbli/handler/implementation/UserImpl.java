package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.request.UserCreationDto;
import org.choerbli.handler.port.UserPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class UserImpl implements UserPort {
    @Override
    public UserDto getById(UUID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserDto create(UserCreationDto creationDto) {
        throw new UnsupportedOperationException();
    }
}
