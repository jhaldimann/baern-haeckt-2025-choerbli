package org.choerbli.controller.dto.request;

import org.choerbli.controller.dto.ConsequenceTypeDto;

public record ConsequenceCreationDto(String description, int orderOfApplication, ConsequenceTypeDto type) {
}
