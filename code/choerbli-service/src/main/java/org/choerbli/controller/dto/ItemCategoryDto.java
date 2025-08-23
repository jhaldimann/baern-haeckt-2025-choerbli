package org.choerbli.controller.dto;

import java.util.UUID;

/**
 * A category of an item description.
 *
 * @param id   The ID of the item category.
 * @param name The name of the item category.
 */
public record ItemCategoryDto(UUID id, String name) {
}
