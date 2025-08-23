package org.choerbli.controller;

import lombok.RequiredArgsConstructor;
import org.choerbli.controller.dto.ItemCategoryDto;
import org.choerbli.controller.dto.ItemDto;
import org.choerbli.controller.dto.request.ItemUpdateDto;
import org.choerbli.handler.ServiceFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/choerbli")
@RequiredArgsConstructor
public class ItemController {
    private final ServiceFacade serviceFacade;

    @PatchMapping("/update")
    public ResponseEntity<ItemDto> update(@RequestPart(name = "creationDto")ItemUpdateDto updateDto) {
        final ItemDto item = this.serviceFacade.updateItem(updateDto);

        return ResponseEntity.ok(item);
    }
}
