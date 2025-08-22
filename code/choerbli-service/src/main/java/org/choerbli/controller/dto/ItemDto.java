package org.choerbli.controller.dto;

import jakarta.annotation.Nullable;

import java.util.Optional;

/**
 * An item in a choerbli.
 *
 * @param choerbli      The choerbli the item belongs to.
 * @param user          The user that the item is assigned to.
 * @param points        The amount of points the item awards.
 * @param price         The price of the item.
 */
public record ItemDto(ChoerbliDto choerbli, @Nullable UserDto user, Integer points, Double price) {
}
