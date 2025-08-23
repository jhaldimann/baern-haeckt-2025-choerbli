package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.UserVoteInfoDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.controller.dto.request.VoteUpdateDto;
import org.choerbli.handler.port.VotePort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class VoteImpl implements VotePort {
    @Override
    public VoteDto create(VoteCreationDto creationDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public VoteDto update(VoteUpdateDto updateDto) {
        throw new UnsupportedOperationException();
    }

    @Override
    public UserVoteInfoDto getUserVoteInfo(UUID user) {
        throw new UnsupportedOperationException();
    }
}
