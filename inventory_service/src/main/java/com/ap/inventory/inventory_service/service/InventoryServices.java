package com.ap.inventory.inventory_service.service;

import com.ap.inventory.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryServices {
    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode,Integer quantity){
        log.info("---Start---");
        boolean isInStock = inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
        log.info("---End---");
        return isInStock;
    }

}
