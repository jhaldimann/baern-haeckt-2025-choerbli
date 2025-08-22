package org.choerbli.controller.dto.request;

import java.util.UUID;

public record VoteCreationDto(UUID userId, UUID choerbliId, UUID itemDescriptionId, Integer factor) {
}
