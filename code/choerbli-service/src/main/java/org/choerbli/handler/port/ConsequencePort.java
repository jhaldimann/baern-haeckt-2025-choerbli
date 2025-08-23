package org.choerbli.handler.port;

import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.controller.dto.request.ConsequencesCreationDto;

import java.util.List;

public interface ConsequencePort {
    List<ConsequenceDto> create(final ConsequencesCreationDto creationDtos);
}
