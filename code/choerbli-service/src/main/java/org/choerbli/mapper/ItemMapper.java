package org.choerbli.mapper;

import org.choerbli.controller.dto.ChoerbliStateDto;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.model.Item;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ChoerbliStateMapper.class, ConsequenceTypeMapper.class})
public interface ItemMapper {
    ItemDto toItemDto(final Item item);
}
