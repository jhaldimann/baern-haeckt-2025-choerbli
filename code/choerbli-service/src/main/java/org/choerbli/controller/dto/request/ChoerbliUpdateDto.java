package org.choerbli.controller.dto.request;

import jakarta.annotation.Nullable;
import org.choerbli.controller.dto.ChoerbliStateDto;
import org.choerbli.controller.dto.UserDto;

import java.util.Date;
import java.util.UUID;

public record ChoerbliUpdateDto(UUID id, @Nullable UserDto organizer, @Nullable ChoerbliStateDto state, @Nullable String name, @Nullable String description, @Nullable
                                Date startDate, @Nullable Date endDate) {
}
