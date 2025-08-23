package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.choerbli.controller.dto.ItemCategoryDto;
import org.choerbli.controller.dto.UserVoteInfoDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.controller.dto.request.VoteUpdateDto;
import org.choerbli.handler.port.VotePort;
import org.choerbli.mapper.ItemCategoryMapper;
import org.choerbli.mapper.VoteMapper;
import org.choerbli.model.Choerbli;
import org.choerbli.model.ItemDescription;
import org.choerbli.model.User;
import org.choerbli.model.Vote;
import org.choerbli.repository.ChoerbliRepository;
import org.choerbli.repository.ItemDescriptionRepository;
import org.choerbli.repository.UserRepository;
import org.choerbli.repository.VoteRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
class VoteImpl implements VotePort {
    private final VoteRepository voteRepository;
    private final ChoerbliRepository choerbliRepository;
    private final UserRepository userRepository;
    private final ItemDescriptionRepository itemDescriptionRepository;
    private final VoteMapper voteMapper;
    private final ItemCategoryMapper itemCategoryMapper;

    @Override
    @SneakyThrows
    public VoteDto create(VoteCreationDto creationDto) {
        final List<Vote> existingVotes = this.voteRepository.findByUserId(creationDto.userId());

        for (Vote v : existingVotes) {
            if (v.getChoerbli().getId().equals(creationDto.choerbliId()) && v.getItemDescription().getId().equals(creationDto.itemDescriptionId())) {
                throw new BadRequestException("The user %s has already voted for item %s.".formatted(creationDto.userId(), creationDto.itemDescriptionId()));
            }
        }

        final Vote vote = this.voteMapper.toVote(creationDto);

        final Choerbli choerbli = this.choerbliRepository.findById(creationDto.choerbliId()).orElseThrow(() -> new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(creationDto.choerbliId())));
        final User user = this.userRepository.findById(creationDto.userId()).orElseThrow(() -> new EntityNotFoundException("The user with ID %s was not found.".formatted(creationDto.userId())));
        final ItemDescription itemDescription = this.itemDescriptionRepository.findById(creationDto.itemDescriptionId()).orElseThrow(() -> new EntityNotFoundException("The item description with ID %s was not found.".formatted(creationDto.itemDescriptionId())));

        vote.setChoerbli(choerbli);
        vote.setUser(user);
        vote.setItemDescription(itemDescription);

        this.voteRepository.save(vote);

        return this.voteMapper.toVoteDto(vote);
    }

    @Override
    public VoteDto update(VoteUpdateDto updateDto) {
        final Optional<Vote> vote = this.voteRepository.findById(updateDto.id());

        if (vote.isEmpty()) {
            throw new EntityNotFoundException("The vote with ID %s was not found.".formatted(updateDto.id()));
        }

        vote.get().setFactor(updateDto.factor());

        this.voteRepository.save(vote.get());

        return this.voteMapper.toVoteDto(vote.get());
    }

    @Override
    public UserVoteInfoDto getUserVoteInfo(UUID userId) {
        final List<Vote> userVotes = this.voteRepository.findByUserId(userId);

        final Map<ItemCategoryDto, Integer> remainingVotes = userVotes.stream()
                .collect(Collectors.groupingBy(
                        vote -> this.itemCategoryMapper.toItemCategoryDto(vote.getItemDescription().getCategory()),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> VoteDto.DEFAULT_VOTES_PER_CATEGORY - count.intValue()
                        )));

        return new UserVoteInfoDto(userId, userVotes.stream().map(this.voteMapper::toVoteDto).toList(), remainingVotes);
    }
}
