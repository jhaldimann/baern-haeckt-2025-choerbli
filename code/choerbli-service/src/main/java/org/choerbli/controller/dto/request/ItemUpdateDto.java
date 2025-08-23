package org.choerbli.controller.dto.request;

import jakarta.annotation.Nullable;

import java.util.UUID;

public record ItemUpdateDto(@Nullable UUID userId, @Nullable Integer points, @Nullable Double price) {
}
