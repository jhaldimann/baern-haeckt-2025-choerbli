package org.choerbli.controller.dto;

import java.util.Dictionary;
import java.util.List;
import java.util.UUID;

public record UserVoteInfoDto(UUID userId, List<VoteDto> votes, Dictionary<ItemCategoryDto, Integer> remainingVotes) {
}
