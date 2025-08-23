package org.choerbli.controller.dto;

import org.choerbli.model.Choerbli;

import java.util.List;

public record ChoerbliSummaryDto(Choerbli choerbli, List<UserSummaryDto> userSummaries) {
}
