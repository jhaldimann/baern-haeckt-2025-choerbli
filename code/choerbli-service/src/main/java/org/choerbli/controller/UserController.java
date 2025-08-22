package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.UserDto;
import org.choerbli.controller.dto.request.UserCreationDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final ServiceFacade serviceFacade;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable(name = "userId") UUID userId) {
        final UserDto user = this.serviceFacade.getUserById(userId);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestPart(name = "creationDto") UserCreationDto creationDto) {
        final UserDto user = this.serviceFacade.createUser(creationDto);

        return ResponseEntity.ok(user);
    }
}
