package org.choerbli.handler;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.*;
import org.choerbli.controller.dto.request.*;
import org.choerbli.handler.port.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Transactional
public class ServiceFacade {
    private final ChoerbliPort choerbliPort;
    private final UserPort userPort;
    private final VotePort votePort;
    private final ItemPort itemPort;
    private final ItemDescriptionPort itemDescriptionPort;

    public ChoerbliDto getChoerbliById(final UUID choerbliId) {
        return this.choerbliPort.getById(choerbliId);
    }

    public ChoerbliDto createChoerbli(final ChoerbliCreationDto creationDto) {
        return this.choerbliPort.create(creationDto);
    }

    public ChoerbliDto updateChoerbli(final ChoerbliUpdateDto updateDto) {
        return this.choerbliPort.update(updateDto);
    }

    public void deleteChoerbli(final UUID choerbliId) {
        this.choerbliPort.delete(choerbliId);
    }

    public UserDto getUserById(final UUID userId) {
        return this.userPort.getById(userId);
    }

    public UserDto createUser(final UserCreationDto creationDto) {
        return this.userPort.create(creationDto);
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

    public VoteDto updateVote(final VoteUpdateDto updateDto) {
        return this.votePort.update(updateDto);
    }

    public UserVoteInfoDto getUserVoteInfo(final UUID userId) {
        return this.votePort.getUserVoteInfo(userId);
    }

    public ItemDto assignItem(final UUID itemId, final UUID userId) {
        return this.itemPort.assign(itemId, userId);
    }

    public ItemDto updateItemPrice(final UUID itemId, final Double price) {
        return this.itemPort.updatePrice(itemId, price);
    }

    public List<ItemDescriptionDto> getDescriptions() {
        return this.itemDescriptionPort.getAll();
    }
}
