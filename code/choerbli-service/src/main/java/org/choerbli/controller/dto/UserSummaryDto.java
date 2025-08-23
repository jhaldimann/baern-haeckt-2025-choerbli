package org.choerbli.controller.dto;

import jakarta.annotation.Nullable;

public record UserSummaryDto(UserDto user, int rank, double amountPaid, double amountDue,
                             @Nullable ConsequenceDto consequence) {
}
