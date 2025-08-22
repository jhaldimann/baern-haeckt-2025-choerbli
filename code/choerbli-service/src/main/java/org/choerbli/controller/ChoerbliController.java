package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
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
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/create")
    public ResponseEntity<ChoerbliDto> create(@RequestPart(name = "creationDto") ChoerbliCreationDto creationDto) {
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/update")
    public ResponseEntity<ChoerbliDto> update(@RequestPart(name = "updateDto")ChoerbliUpdateDto updateDto) {
        return ResponseEntity.badRequest().build();
    }
}
