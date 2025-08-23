package org.choerbli.controller.dto.request;

import org.choerbli.controller.dto.ConsequenceTypeDto;

import java.util.UUID;

public record ConsequenceCreationDto(UUID choerbliId, String description, int orderOfApplication, ConsequenceTypeDto type) {
}
