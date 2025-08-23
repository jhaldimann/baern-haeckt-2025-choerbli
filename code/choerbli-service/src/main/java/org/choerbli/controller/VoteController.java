package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.UserVoteInfoDto;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.controller.dto.request.VoteUpdateDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VoteController {
    private final ServiceFacade serviceFacade;

    @PostMapping("/create")
    public ResponseEntity<VoteDto> create(@RequestPart(name = "creationDto") VoteCreationDto creationDto) {
        final VoteDto vote = this.serviceFacade.createVote(creationDto);

        return ResponseEntity.ok(vote);
    }

    @PatchMapping("/update")
    public ResponseEntity<VoteDto> update(@RequestPart(name = "updateDto") VoteUpdateDto updateDto) {
        final VoteDto vote = this.serviceFacade.updateVote(updateDto);

        return ResponseEntity.ok(vote);
    }

    @GetMapping("/vote-info/{userId}")
    public ResponseEntity<UserVoteInfoDto> getUserVoteInfo(@PathVariable(name = "userId") UUID userId) {
        final UserVoteInfoDto userVoteInfo = this.serviceFacade.getUserVoteInfo(userId);

        return ResponseEntity.ok(userVoteInfo);
    }
}
