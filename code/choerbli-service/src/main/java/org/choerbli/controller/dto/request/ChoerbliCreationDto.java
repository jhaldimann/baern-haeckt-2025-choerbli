package org.choerbli.controller.dto.request;

import org.choerbli.controller.dto.ConsequenceDto;

import java.util.Date;
import java.util.List;

public record ChoerbliCreationDto(String organizerName, String organizerEmail, String name, String description,
                                  Date startDate, Date endDate, List<ConsequenceCreationDto> consequences) {
}
