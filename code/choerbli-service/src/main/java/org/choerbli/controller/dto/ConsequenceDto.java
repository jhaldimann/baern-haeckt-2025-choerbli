package org.choerbli.controller.dto;

/**
 * The consequence of a choerbli.
 *
 * @param description       The description of the consequence.
 * @param choerbli          The choerbli to which the consequence belongs to.
 */
public record ConsequenceDto(String description, ChoerbliDto choerbli) {
}
