package org.choerbli.handler.port;

import org.choerbli.controller.dto.ItemDto;

import java.util.UUID;

public interface ItemPort {
    ItemDto assign(UUID id, UUID userId);

    ItemDto updatePrice(UUID id, Double price);
}
