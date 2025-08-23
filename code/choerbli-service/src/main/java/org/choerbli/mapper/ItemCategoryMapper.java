package org.choerbli.mapper;

import org.choerbli.controller.dto.ItemCategoryDto;
import org.choerbli.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemCategoryMapper {
    ItemCategoryDto toItemCategoryDto(final Category category);
}
