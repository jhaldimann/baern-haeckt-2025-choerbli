package org.choerbli.controller.dto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record UserVoteInfoDto(UUID userId, List<VoteDto> votes, Map<ItemCategoryDto, Integer> remainingVotes) {
}
