package org.choerbli.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.*;
import org.choerbli.handler.port.ChoerbliPort;
import org.choerbli.handler.port.ItemPort;
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
    private final ItemPort itemPort;

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

    public ChoerbliDto changeChoerbliToAssigning(final UUID choerbliId) {
        return this.choerbliPort.changeToAssigning(choerbliId);
    }

    public ChoerbliDto finishChoerbli(final UUID choerbliId) {
        return this.choerbliPort.finish(choerbliId);
    }

    public VoteDto createVote(final VoteCreationDto voteDto) {
        return this.votePort.create(voteDto);
    }

    public ItemDto updateItem(final ItemUpdateDto updateDto) {
        return this.itemPort.update(updateDto);
    }
}
