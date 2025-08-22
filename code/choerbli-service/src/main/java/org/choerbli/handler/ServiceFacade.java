package org.choerbli.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
import org.choerbli.controller.dto.request.UserCreationDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.handler.port.ChoerbliPort;
import org.choerbli.handler.port.UserPort;
import org.choerbli.handler.port.VotePort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class ServiceFacade {
    private final ChoerbliPort choerbliPort;
    private final UserPort userPort;
    private final VotePort votePort;

    public ChoerbliDto getChoerbliById(final UUID choerbliId) {
        return this.choerbliPort.getById(choerbliId);
    }

    public ChoerbliDto createChoerbli(final ChoerbliCreationDto creationDto) {
        return this.choerbliPort.create(creationDto);
    }

    public ChoerbliDto updateChoerbli(final ChoerbliUpdateDto updateDto) {
        return this.choerbliPort.update(updateDto);
    }

    public UserDto getUserById(final UUID userId) {
        return this.userPort.getById(userId);
    }

    public UserDto createUser(final UserCreationDto creationDto) {
        return this.userPort.create(creationDto);
    }

    public ChoerbliDto addUserToChoerbli(final UUID choerbliId, final UUID userId) {
        return this.choerbliPort.addUser(choerbliId, userId);
    }

    public VoteDto createVote(final VoteCreationDto voteDto) {
        return this.votePort.create(voteDto);
    }
}
