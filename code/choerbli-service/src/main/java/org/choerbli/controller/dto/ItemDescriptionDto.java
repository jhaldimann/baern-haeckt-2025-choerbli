package org.choerbli.controller.dto;

/**
 * The description of an item.
 *
 * @param name          The name of the item.
 * @param category      The category of the item.
 */
public record ItemDescriptionDto(String name, ItemCategoryDto category) {
}
