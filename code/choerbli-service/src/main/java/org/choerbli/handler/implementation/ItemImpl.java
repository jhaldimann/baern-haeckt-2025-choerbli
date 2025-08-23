package org.choerbli.handler.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.handler.port.ItemPort;
import org.choerbli.mapper.ItemMapper;
import org.choerbli.model.Item;
import org.choerbli.repository.ItemRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class ItemImpl implements ItemPort {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public ItemDto assign(UUID id, UUID userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemDto updatePrice(UUID id, Double price) {
        final Optional<Item> item = this.itemRepository.findById(id);

        if (item.isEmpty()) {
            throw new EntityNotFoundException("The item with ID %s was not found.".formatted(id));
        }

        item.get().setPrice(price);

        this.itemRepository.save(item.get());

        return this.itemMapper.toItemDto(item.get());
    }
}
