package org.choerbli.controller.dto;

public record UserSummaryDto(UserDto user, int rank, double amountPaid, double amountDue) {
}
