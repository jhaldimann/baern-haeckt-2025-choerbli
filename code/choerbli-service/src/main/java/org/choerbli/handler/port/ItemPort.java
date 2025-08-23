package org.choerbli.handler.port;

import org.choerbli.controller.dto.ItemDto;
import org.choerbli.controller.dto.request.ItemUpdateDto;

public interface ItemPort {
    ItemDto update(ItemUpdateDto updateDto);
}
