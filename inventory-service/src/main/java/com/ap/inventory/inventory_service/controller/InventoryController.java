package com.ap.inventory.inventory_service.controller;

import com.ap.inventory.inventory_service.repository.InventoryRepository;
import com.ap.inventory.inventory_service.service.InventoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryServices inventoryServices;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity){
        return inventoryServices.isInStock(skuCode,quantity);
    }

}
