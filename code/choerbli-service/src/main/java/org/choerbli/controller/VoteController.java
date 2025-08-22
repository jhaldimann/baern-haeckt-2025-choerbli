package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.VoteDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/vote")
@RequiredArgsConstructor
public class VoteController {
    private final ServiceFacade serviceFacade;



    @PostMapping("/create")
    public ResponseEntity<VoteDto> create(@RequestPart(name = "creationDto")VoteCreationDto creationDto) {
        final VoteDto vote = this.serviceFacade.createVote(creationDto);

        return ResponseEntity.ok(vote);
    }
}
