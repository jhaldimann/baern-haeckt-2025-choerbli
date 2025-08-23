package org.choerbli.handler.port;

import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;

import java.util.List;

public interface ConsequencePort {
    List<ConsequenceDto> create(final List<ConsequenceCreationDto> creationDtos);
}
