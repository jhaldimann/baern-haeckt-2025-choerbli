package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/consequence")
@RequiredArgsConstructor
public class ConsequenceController {
    private final ServiceFacade serviceFacade;

    @PostMapping("/create")
    public ResponseEntity<ConsequenceDto> create(@RequestPart(name = "creationDto") ConsequenceCreationDto creationDto) {
        final ConsequenceDto consequence = this.serviceFacade.createConsequence(creationDto);

        return ResponseEntity.ok(consequence);
    }
}
