package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ChoerbliSummaryDto;
import org.choerbli.controller.dto.request.ChoerbliCreationDto;
import org.choerbli.controller.dto.ChoerbliDto;
import org.choerbli.controller.dto.request.ChoerbliUpdateDto;
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

    @PostMapping(value = "/create")
    public ResponseEntity<ChoerbliDto> create(@RequestPart(name = "creationDto") ChoerbliCreationDto creationDto) {
        final ChoerbliDto choerbli = this.serviceFacade.createChoerbli(creationDto);

        return ResponseEntity.ok(choerbli);
    }

    @PatchMapping("/update")
    public ResponseEntity<ChoerbliDto> update(@RequestPart(name = "updateDto")ChoerbliUpdateDto updateDto) {
        final ChoerbliDto choerbli = this.serviceFacade.updateChoerbli(updateDto);

        return ResponseEntity.ok(choerbli);
    }

    @DeleteMapping("/delete/{choerbliId}")
    public ResponseEntity<String> delete(@PathVariable(name = "choerbliId") UUID choerbliId) {
        this.serviceFacade.deleteChoerbli(choerbliId);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{choerbliId}/assigning")
    public ResponseEntity<ChoerbliDto> changeToAssigning(@PathVariable(name = "choerbliId") UUID choerbliId) {
        final ChoerbliDto choerbli = this.serviceFacade.changeChoerbliToAssigning(choerbliId);

        return ResponseEntity.ok(choerbli);
    }

    @PatchMapping("/{choerbliId}/finish")
    public ResponseEntity<ChoerbliDto> finish(@PathVariable(name = "choerbliId") UUID choerbliId) {
        final ChoerbliDto choerbli = this.serviceFacade.finishChoerbli(choerbliId);

        return ResponseEntity.ok(choerbli);
    }

    @GetMapping("/summary/{choerbliId}")
    public ResponseEntity<ChoerbliSummaryDto> getSummary(@PathVariable(name = "choerbliId") UUID choerbliId) {
        final ChoerbliSummaryDto summary = this.serviceFacade.getChoerbliSummary(choerbliId);

        return ResponseEntity.ok(summary);
    }
}
