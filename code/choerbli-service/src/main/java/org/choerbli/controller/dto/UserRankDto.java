package org.choerbli.controller.dto;

/**
 * The rank of a user in a choerbli.
 *
 * @param user          The user to which the rank belongs to.
 * @param choerbli      The choerbli to which the rank belongs to.
 * @param points        The amount of points.
 */
public record UserRankDto(UserDto user, ChoerbliDto choerbli, Integer points) {
}
