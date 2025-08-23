package org.choerbli.controller.dto.request;

import java.util.Date;

public record ChoerbliCreationDto(String organizerName, String organizerEmail, String name, String description, Date startDate, Date endDate) {
}
