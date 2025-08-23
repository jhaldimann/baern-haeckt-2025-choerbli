package org.choerbli.handler.port;

import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;

public interface ConsequencePort {
    ConsequenceDto create(final ConsequenceCreationDto creationDto);
}
