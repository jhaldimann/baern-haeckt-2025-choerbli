package org.choerbli.controller.dto.request;

import org.choerbli.controller.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public record ChoerbliCreationDto(UUID organizerId, String name, String description, Date startDate, Date endDate) {
}
