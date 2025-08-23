package org.choerbli.mapper;

import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.model.Vote;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ChoerbliStateMapper.class)
public interface VoteMapper {
    VoteDto toVoteDto(final Vote vote);

    Vote toVote(final VoteCreationDto creationDto);
}
