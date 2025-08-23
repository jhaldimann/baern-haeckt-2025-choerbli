package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
import org.choerbli.handler.port.ChoerbliPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class ChoerbliImpl implements ChoerbliPort {
    @Override
    public ChoerbliDto getById(UUID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto create(ChoerbliCreationDto creationDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto update(ChoerbliUpdateDto updateDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto addUser(UUID id, UUID userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto assignUserToItem(UUID id, UUID userId, UUID itemId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto changeToAssigning(UUID id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ChoerbliDto finish(UUID id) {
        throw new UnsupportedOperationException();
    }
}
