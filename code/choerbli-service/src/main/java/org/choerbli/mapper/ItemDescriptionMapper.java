package org.choerbli.mapper;

import org.choerbli.controller.dto.ItemDescriptionDto;
import org.choerbli.model.ItemDescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ItemDescriptionMapper {
    @Mapping(target = "category", source = "itemDescription.category")
    ItemDescriptionDto toItemDescriptionDto(final ItemDescription itemDescription);
}
