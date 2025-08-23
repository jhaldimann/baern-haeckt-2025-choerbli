package org.choerbli.controller.dto;

import lombok.AllArgsConstructor;

import java.util.UUID;

/**
 * The description of an item.
 *
 * @param id       The ID of the item description.
 * @param name     The name of the item description.
 * @param category The category of the item description.
 */
public record ItemDescriptionDto(UUID id, String name, ItemCategoryDto category) {
}
