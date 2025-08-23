package org.choerbli.controller.dto;

import java.util.UUID;

/**
 * The vote of an item in a choerbli.
 *
 * @param itemDescription The item description the vote is for.
 * @param choerbli        The choerbli to which the vote belongs to.
 * @param user            The user to which the vote belongs to.
 * @param factor          The factor of the vote.
 */
public record VoteDto(UUID id, ItemDescriptionDto itemDescription, ChoerbliDto choerbli, UserDto user, Integer factor) {
    public static final Integer DEFAULT_VOTES_PER_CATEGORY = 3;
}
