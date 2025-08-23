package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ConsequenceDto;
import org.choerbli.controller.dto.request.ConsequenceCreationDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/consequence")
@RequiredArgsConstructor
public class ConsequenceController {
    private final ServiceFacade serviceFacade;



    @PostMapping("/create")
    public ResponseEntity<List<ConsequenceDto>> create(@RequestPart(name = "creationDtos") List<ConsequenceCreationDto> creationDtos) {
        final List<ConsequenceDto> consequences = this.serviceFacade.createConsequences(creationDtos);

        return ResponseEntity.ok(consequences);
    }
}
