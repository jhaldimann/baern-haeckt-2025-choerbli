package org.choerbli.handler.port;

import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;

public interface VotePort {
    VoteDto create(VoteCreationDto creationDto);
}
