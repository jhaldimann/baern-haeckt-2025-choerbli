package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.coyote.BadRequestException;
import org.choerbli.controller.dto.*;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.handler.port.ChoerbliPort;
import org.choerbli.mapper.ChoerbliMapper;
import org.choerbli.mapper.ConsequenceMapper;
import org.choerbli.mapper.UserMapper;
import org.choerbli.model.*;
import org.choerbli.repository.ChoerbliRepository;
import org.choerbli.repository.ConsequencesRepository;
import org.choerbli.repository.ItemRepository;
import org.choerbli.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
class ChoerbliImpl implements ChoerbliPort {
    private final ChoerbliRepository choerbliRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ConsequencesRepository consequencesRepository;
    private final ChoerbliMapper choerbliMapper;
    private final UserMapper userMapper;
    private final ConsequenceMapper consequenceMapper;

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

        final Optional<Item> item = choerbli.get().getItems().stream().filter(i -> i.getId().equals(itemId)).findFirst();

        if (item.isEmpty()) {
            throw new EntityNotFoundException("The item with ID %s was not found.".formatted(itemId));
        }

        if (item.get().getChoerbli().getId() != choerbli.get().getId()) {
            throw new BadRequestException("The item choerbli ID %s does not match the choerbli ID %s.".formatted(item.get().getChoerbli().getId(), choerbli.get().getId()));
        }

        item.get().setUser(user.get());

        this.itemRepository.save(item.get());

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliDto changeToAssigning(UUID id) {
        final Optional<Choerbli> choerbli = this.choerbliRepository.findById(id);

        if (choerbli.isEmpty()) {
            throw new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id));
        }

        choerbli.get().setState(ChoerbliStateDto.ASSIGNING.getState());

        final Map<ItemDescription, Integer> itemVotes = choerbli
                .map(Choerbli::getVotes)
                .orElse(Collections.emptySet())
                .stream()
                .collect(Collectors.groupingBy(
                        Vote::getItemDescription,
                        Collectors.summingInt(Vote::getFactor)
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

        for (Item item : choerbli.get().getItems()) {
            User user = item.getUser();

            if (user == null) {
                item.setPoints(ItemDto.DEFAULT_POINTS);

                final List<User> users = this.userRepository.findAllByChoerbliId(choerbli.get().getId());

                user = users.stream().min(Comparator.comparingInt(User::getPoints)).orElse(null);

                if (user == null) {
                    throw new InternalError("The list of users for a choerbli cannot be empty.");
                }
            }

            user.setPoints(user.getPoints() + item.getPoints());

            this.userRepository.save(user);
        }

        return this.choerbliMapper.toChoerbliDto(choerbli.get());
    }

    @Override
    public ChoerbliSummaryDto getSummary(UUID id) {
        final Choerbli choerbli = this.choerbliRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The choerbli with ID %s was not found.".formatted(id)));

        final List<Item> items = this.itemRepository.findAllByChoerbliId(choerbli.getId());

        final Map<ConsequenceTypeDto, List<ConsequenceDto>> consequences = this.consequencesRepository.findAllByChoerbliId(choerbli.getId())
                .stream()
                .map(this.consequenceMapper::toConsequenceDto)
                .collect(Collectors.groupingBy(
                        ConsequenceDto::type,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingInt(ConsequenceDto::orderOfApplication))
                                        .toList())));

        final double totalAmount = items.stream().mapToDouble(Item::getPrice).sum();

        final List<UserDto> rankedUsers = this.userRepository.findAllByChoerbliId(choerbli.getId())
                .stream()
                .sorted(Comparator.comparingInt(User::getPoints))
                .map(userMapper::toUserDto)
                .toList();

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
                            .filter(i -> i.getUser().getId().equals(user.id()))
                            .mapToDouble(Item::getPrice)
                            .sum();

                    final double amountDue = (totalAmount / userCount) - amountPaid;

                    return new UserSummaryDto(user, rank, amountPaid, amountDue, consequence);
                })
                .toList();

        return new ChoerbliSummaryDto(choerbli, userSummaries);
    }
}
