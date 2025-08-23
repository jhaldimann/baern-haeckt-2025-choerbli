package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemDescriptionDto;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {
    private final ServiceFacade serviceFacade;

    @GetMapping("/descriptions")
    public ResponseEntity<List<ItemDescriptionDto>> getDescriptions() {
        final List<ItemDescriptionDto> descriptions = this.serviceFacade.getDescriptions();

        return ResponseEntity.ok(descriptions);
    }

    @PatchMapping("/{itemId}/assign/{userId}")
    public ResponseEntity<ItemDto> update(@PathVariable(name = "itemId") UUID itemId, @PathVariable(name = "userId") UUID userId) {
        final ItemDto item = this.serviceFacade.assignItem(itemId, userId);

        return ResponseEntity.ok(item);
    }


}
