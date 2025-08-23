package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.choerbli.controller.dto.*;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
import org.choerbli.handler.port.ChoerbliPort;
import org.choerbli.mapper.*;
import org.choerbli.model.*;
import org.choerbli.repository.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.summingInt;

@Component
@RequiredArgsConstructor
class ChoerbliImpl implements ChoerbliPort {
    private final ChoerbliRepository choerbliRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ConsequencesRepository consequencesRepository;
    private final VoteRepository voteRepository;
    private final ChoerbliMapper choerbliMapper;
    private final UserMapper userMapper;
    private final ItemMapper itemMapper;
    private final ConsequenceMapper consequenceMapper;
    private final VoteMapper voteMapper;

    @Override
    public ChoerbliDto getById(UUID id) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(id);

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found".formatted(id));
        }

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliDto create(ChoerbliCreationDto creationDto) {
        final Choerbli choerbli = this.choerbliMapper.toChoerbli(creationDto);

        choerbli.setState(ChoerbliStateDto.VOTING.getState());

        this.choerbliRepository.save(choerbli);

        return this.choerbliMapper.toChoerbliDto(choerbli);
    }

    @Override
    public ChoerbliDto update(ChoerbliUpdateDto updateDto) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(updateDto.id());

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(updateDto.id()));
        }

        if (updateDto.name() != null) {
            choerbli.get().setName(updateDto.name());
        }

        if (updateDto.description() != null) {
            choerbli.get().setDescription(updateDto.description());
        }

        this.choerbliRepository.save(choerbli.get());

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public void delete(UUID id) {
        this.choerbliRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public ChoerbliDto assignUserToItem(UUID id, UUID userId, UUID itemId) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(id);

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id));
        }

        final Optional<User> user = this.userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new EntityNotFoundException("The user with ID %s was not found.");
        }

        final Item item = this.itemRepository.findById(itemId).orElseThrow(() -> new EntityNotFoundException("The item with ID %s was not found.".formatted(itemId)));

        if (item.getChoerbli().getId() != choerbli.get().getId()) {
            throw new BadRequestException("The item choerbli ID %s does not match the choerbli ID %s.".formatted(item.getChoerbli().getId(), choerbli.get().getId()));
        }

        item.setUser(user.get());

        this.itemRepository.save(item);

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliDto changeToAssigning(UUID id) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(id);

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id));
        }

        choerbli.get().setState(ChoerbliStateDto.ASSIGNING.getState());

        final Map<ItemDescription, Integer> itemVotes = this.voteRepository.findByChoerbliId(choerbli.get().getId())
                .stream()
                .collect(Collectors.groupingBy(
                        Vote::getItemDescription,
                        summingInt(Vote::getFactor)
                ));

        for (Map.Entry<ItemDescription, Integer> entry : itemVotes.entrySet()) {
            Integer totalVotes = entry.getValue();

            // If the total votes are 0 or smaller, then the item will not be added to the choerbli
            if (totalVotes <= 0) {
                continue;
            }

            final Item item = new Item();

            item.setItemDescription(entry.getKey());
            item.setChoerbli(choerbli.get());
            item.setPoints(ItemDto.DEFAULT_POINTS);
            item.setPrice(0.0);

            this.itemRepository.save(item);
        }

        this.choerbliRepository.save(choerbli.get());

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliDto finish(UUID id) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(id);

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id));
        }

        choerbli.get().setState(ChoerbliStateDto.DONE.getState());

        List<Item> items = this.itemRepository.findAllByChoerbliId(choerbli.get().getId());

        final List<User> users = this.userRepository.findAllByChoerbliId(choerbli.get().getId());

        var opferUser = users.stream().min(Comparator.comparingInt(User::getPoints)).orElse(null);

        for (Item item : items) {
            User user = item.getUser();

            if (user == null) {
                item.setPoints(ItemDto.DEFAULT_POINTS);
                if (opferUser == null) {
                    throw new InternalError("The list of users for a choerbli cannot be empty.");
                }
                item.setUser(opferUser);
                this.itemRepository.save(item);
            }
        }

        items = this.itemRepository.findAllByChoerbliId(choerbli.get().getId());
        items.stream()
                .collect(Collectors.groupingBy(Item::getUser, summingInt(Item::getPoints)))
                .forEach((user, value) -> {
                    user.setPoints(value);
                    userRepository.save(user);
                });

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliSummaryDto getSummary(UUID id) {
        final Choerbli choerbli = this.choerbliRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id)));

        final List<ItemDto> items = this.itemRepository.findAllByChoerbliId(choerbli.getId()).stream().map(this.itemMapper::toItemDto).toList();

        final List<ConsequenceDto> consequenceDtos = this.consequencesRepository.findAllByChoerbliId(choerbli.getId()).stream().map(this.consequenceMapper::toConsequenceDto).toList();

        final Map<ConsequenceTypeDto, List<ConsequenceDto>> consequences = consequenceDtos
                .stream()
                .collect(Collectors.groupingBy(
                        ConsequenceDto::type,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(ConsequenceDto::orderOfApplication))
                                        .toList())));

        final double totalAmount = items.stream().mapToDouble(ItemDto::price).sum();

        final List<UserDto> rankedUsers = this.userRepository.findAllByChoerbliId(choerbli.getId())
                .stream()
                .sorted(Comparator.comparingInt(User::getPoints))
                .map(userMapper::toUserDto)
                .toList().reversed();

        final int userCount = rankedUsers.size();

        final List<ConsequenceDto> rewards = consequences.getOrDefault(ConsequenceTypeDto.REWARD, Collections.emptyList());
        final List<ConsequenceDto> punishments = consequences.getOrDefault(ConsequenceTypeDto.PUNISHMENT, Collections.emptyList()).reversed();

        final int halfUsers = rankedUsers.size() / 2;

        final int appliedRewards = Math.min(halfUsers, rewards.size());
        final int appliedPunishments = Math.min(halfUsers, punishments.size());

        List<UserSummaryDto> userSummaries = IntStream.range(0, userCount)
                .mapToObj(index -> {
                    UserDto user = rankedUsers.get(index);
                    final int rank = index + 1;

                    ConsequenceDto consequence = null;

                    final int rankFromBottom = rankedUsers.size() - rank + 1;

                    if (rank <= halfUsers && rank <= appliedRewards) {
                        consequence = rewards.get(rank - 1);
                    } else if (rankFromBottom <= halfUsers && rankFromBottom <= appliedPunishments) {
                        consequence = punishments.get(rankFromBottom - 1);
                    }

                    final double amountPaid = items.stream()
                            .filter(i -> i.user() != null && i.user().id().equals(user.id()))
                            .mapToDouble(ItemDto::price)
                            .sum();

                    final double amountDue = (totalAmount / userCount) - amountPaid;

                    return new UserSummaryDto(user, rank, amountPaid, amountDue, consequence);
                })
                .toList();

        final List<VoteDto> votes = this.voteRepository.findByChoerbliId(choerbli.getId()).stream().map(this.voteMapper::toVoteDto).toList();

        return new ChoerbliSummaryDto(choerbli, userSummaries, votes, items, consequenceDtos);
    }
}
