package org.choerbli.controller.dto;

import java.util.List;
import java.util.UUID;

/**
 * A user of a choerbli.
 *
 * @param id        The ID of the user.
 * @param email     The email of the user.
 * @param name      The name of the user.
 */
public record UserDto(UUID id, String email, String name, List<ChoerbliDto> choerblis) {
}
