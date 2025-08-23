package org.choerbli.controller.dto;

import jakarta.annotation.Nullable;

import java.util.UUID;

/**
 * An item in a choerbli.
 *
 * @param id              The ID of the item.
 * @param choerbli        The choerbli the item belongs to.
 * @param user            The user that the item is assigned to.
 * @param points          The amount of points the item awards.
 * @param price           The price of the item.
 * @param itemDescription The description of the item.
 */
public record ItemDto(UUID id, ChoerbliDto choerbli, @Nullable UserDto user, Integer points, Double price,
                      ItemDescriptionDto itemDescription) {
    public static final int DEFAULT_POINTS = 2;
    public static final int UNASSIGNED_POINT_INCREASE = 1;
}
