package org.choerbli.handler.implementation;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDescriptionDto;
import org.choerbli.handler.port.ItemDescriptionPort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
class ItemDescriptionImpl implements ItemDescriptionPort {
    @Override
    public List<ItemDescriptionDto> getAll() {
        throw new UnsupportedOperationException();
    }
}
