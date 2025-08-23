package org.choerbli.controller.dto;

import java.util.UUID;

/**
 * The consequence of a choerbli.
 *
 * @param id                 The ID of the consequence.
 * @param description        The description of the consequence.
 * @param orderOfApplication The order in which the consequence is applied
 * @param type               The type of the consequence.
 * @param choerbli           The choerbli to which the consequence belongs to.
 */
public record ConsequenceDto(UUID id, String description, int orderOfApplication, ConsequenceTypeDto type,
                             ChoerbliDto choerbli) {
}
