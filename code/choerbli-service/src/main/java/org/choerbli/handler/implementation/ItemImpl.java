package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.handler.port.ItemPort;
import org.choerbli.mapper.ItemMapper;
import org.choerbli.model.Item;
import org.choerbli.model.User;
import org.choerbli.repository.ItemRepository;
import org.choerbli.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class ItemImpl implements ItemPort {
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final ItemMapper itemMapper;

    @Override
    public ItemDto assign(UUID id, UUID userId) {
        final Item item = this.itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The item with ID %s was not found.".formatted(id)));
        final User user = this.userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("The user with ID %s was not found.".formatted(userId)));

        item.setUser(user);

        this.itemRepository.save(item);

        final List<Item> items = this.itemRepository.findAllByChoerbliId(item.getChoerbli().getId());

        final List<Item> unassignedItems = items.stream().filter(i -> i.getUser() == null).toList();

        for (Item unassignedItem : unassignedItems) {
            unassignedItem.setPoints(unassignedItem.getPoints() + ItemDto.UNASSIGNED_POINT_INCREASE);

            this.itemRepository.save(unassignedItem);
        }

        return this.itemMapper.toItemDto(item);
    }

    @Override
    public ItemDto updatePrice(UUID id, Double price) {
        final Item item = this.itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The item with ID %s was not found.".formatted(id)));

        item.setPrice(price);

        this.itemRepository.save(item);

        return this.itemMapper.toItemDto(item);
    }
}
