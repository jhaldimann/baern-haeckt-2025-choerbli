package org.choerbli.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The choerbli contains the information to describe a choerbli.
 *
 * @param id            The ID of the choerbli.
 * @param name          The name of the choerbli.
 * @param description   The description of the choerbli.
 * @param organizer     The organizer of the choerbli.
 * @param startDate     The start date of the choerbli.
 * @param endDate       The end date of the choerbli.
 * @param state         The state of the choerbli.
 */
public record ChoerbliDto(UUID id, String name, String description, UserDto organizer, Date startDate, Date endDate, ChoerbliStateDto state, List<UserDto> users, List<VoteDto> votes, List<ItemDto> items) {
}
