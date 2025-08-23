package org.choerbli.controller.dto;

import java.util.UUID;

/**
 * A user of a choerbli.
 *
 * @param id        The ID of the user.
 * @param email     The email of the user.
 * @param name      The name of the user.
 * @param choerbli  The choerbli the user belongs to.
 * @param points    The points of the user in the choerbli.
 */
public record UserDto(UUID id, String email, String name, ChoerbliDto choerbli, int points) {
    public static final int DEFAULT_POINTS = 10;
}
