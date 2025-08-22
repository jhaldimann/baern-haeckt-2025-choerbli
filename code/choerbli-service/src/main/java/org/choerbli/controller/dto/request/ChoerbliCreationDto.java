package org.choerbli.controller.dto.request;

import org.choerbli.controller.dto.UserDto;

import java.util.Date;

public record ChoerbliCreationDto(UserDto organizer, String name, String description, Date startDate, Date endDate) {
}
