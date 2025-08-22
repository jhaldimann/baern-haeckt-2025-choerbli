package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
import org.choerbli.controller.dto.request.VoteCreationDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/choerbli")
@RequiredArgsConstructor
public class ChoerbliController {
    private final ServiceFacade serviceFacade;

    @GetMapping("/{choerbliId}")
    public ResponseEntity<ChoerbliDto> getById(@PathVariable(name = "choerbliId") UUID choerbliId) {
        final ChoerbliDto choerbli = this.serviceFacade.getChoerbliById(choerbliId);

        return ResponseEntity.ok(choerbli);
    }

    @PostMapping("/create")
    public ResponseEntity<ChoerbliDto> create(@RequestPart(name = "creationDto") ChoerbliCreationDto creationDto) {
        final ChoerbliDto choerbli = this.serviceFacade.createChoerbli(creationDto);

        return ResponseEntity.ok(choerbli);
    }

    @PatchMapping("/update")
    public ResponseEntity<ChoerbliDto> update(@RequestPart(name = "updateDto")ChoerbliUpdateDto updateDto) {
        final ChoerbliDto choerbli = this.serviceFacade.updateChoerbli(updateDto);

        return ResponseEntity.ok(choerbli);
    }

    @PatchMapping("/{choerbliId}/add-user/{userId}")
    public ResponseEntity<ChoerbliDto> addUser(@PathVariable(name = "choerbliId") UUID choerbliId, @PathVariable(name = "userId") UUID userId) {
        final ChoerbliDto choerbli = this.serviceFacade.addUserToChoerbli(choerbliId, userId);

        return ResponseEntity.ok(choerbli);
    }
}
