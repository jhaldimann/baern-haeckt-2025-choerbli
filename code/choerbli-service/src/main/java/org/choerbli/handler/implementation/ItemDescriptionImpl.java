package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDescriptionDto;
import org.choerbli.handler.port.ItemDescriptionPort;
import org.choerbli.mapper.ItemDescriptionMapper;
import org.choerbli.model.ItemDescription;
import org.choerbli.repository.ItemDescriptionRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ItemDescriptionImpl implements ItemDescriptionPort {
    private final ItemDescriptionRepository itemDescriptionRepository;
    private final ItemDescriptionMapper itemDescriptionMapper;

    @Override
    public List<ItemDescriptionDto> getAll() {
        final List<ItemDescription> descriptions = this.itemDescriptionRepository.findAll();

        return descriptions.stream().map(itemDescriptionMapper::toItemDescriptionDto).toList();
    }
}
