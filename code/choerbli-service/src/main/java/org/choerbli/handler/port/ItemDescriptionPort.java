package org.choerbli.handler.port;

import org.choerbli.controller.dto.ItemDescriptionDto;

import java.util.List;

public interface ItemDescriptionPort {
    List<ItemDescriptionDto> getAll();
}
