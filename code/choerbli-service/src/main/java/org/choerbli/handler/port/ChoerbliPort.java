package org.choerbli.handler.port;

import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;

import java.util.UUID;

public interface ChoerbliPort {
    ChoerbliDto getById(UUID id);

    ChoerbliDto create(ChoerbliCreationDto creationDto);

    ChoerbliDto update(ChoerbliUpdateDto updateDto);

    void delete(UUID id);

    ChoerbliDto addUser(UUID id, UUID userId);

    ChoerbliDto assignUserToItem(UUID id, UUID userId, UUID itemId);

    ChoerbliDto changeToAssigning(UUID id);

    ChoerbliDto finish(UUID id);
}
