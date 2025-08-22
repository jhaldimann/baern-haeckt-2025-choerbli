package org.choerbli.handler.port;

import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;

import java.util.UUID;

public interface ChoerbliPort {
    ChoerbliDto getById(UUID id);

    ChoerbliDto create(ChoerbliCreationDto creationDto);

    ChoerbliDto update(ChoerbliUpdateDto updateDto);

    ChoerbliDto addUser(UUID id, UUID userId);
}
