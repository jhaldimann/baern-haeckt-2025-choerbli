package org.choerbli.handler.port;

import org.choerbli.controller.dto.UserVoteInfoDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.controller.dto.request.VoteUpdateDto;

import java.util.UUID;

public interface VotePort {
    VoteDto create(VoteCreationDto creationDto);

    VoteDto update(VoteUpdateDto updateDto);

    UserVoteInfoDto getUserVoteInfo(UUID user);
}
