package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.handler.port.ItemPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
class ItemImpl implements ItemPort {
    @Override
    public ItemDto assign(UUID id, UUID userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ItemDto updatePrice(UUID id, Double price) {
        throw new UnsupportedOperationException();
    }
}
