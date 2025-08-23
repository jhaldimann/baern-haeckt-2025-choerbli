package org.choerbli.controller.dto.request;

import java.util.UUID;

public record UserCreationDto(String email, String name, UUID choerbliId) {
}
