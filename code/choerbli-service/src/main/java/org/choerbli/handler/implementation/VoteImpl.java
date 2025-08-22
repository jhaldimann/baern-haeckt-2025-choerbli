package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.handler.port.VotePort;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class VoteImpl implements VotePort {
    @Override
    public VoteDto create(VoteCreationDto creationDto) {
        throw new UnsupportedOperationException();
    }
}
