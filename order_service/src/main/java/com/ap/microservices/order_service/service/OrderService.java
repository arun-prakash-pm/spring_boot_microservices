package com.ap.microservices.order_service.service;

import com.ap.microservices.order_service.client.InventoryClient;
import com.ap.microservices.order_service.dto.OrderRequest;
import com.ap.microservices.order_service.event.OrderPlacedEvent;
import com.ap.microservices.order_service.model.Order;
import com.ap.microservices.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {



    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;

    public void placeOrder(OrderRequest orderRequest){

       var isProductInStock= inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);

            OrderPlacedEvent orderPlacedEvent=new OrderPlacedEvent(order.getOrderNumber(),orderRequest.userDetails().email());
            kafkaTemplate.send("order_placed",orderPlacedEvent);
            log.info("Order placed..."+orderPlacedEvent);

        }else {
            throw new RuntimeException("Product with SkuCode"+orderRequest.skuCode()+"is not in stock");
        }
    }
}
