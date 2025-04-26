package com.ap.microservices.product_service.dto;

import java.math.BigDecimal;

public record ProductResponse(String name,String description, BigDecimal price) {
}
