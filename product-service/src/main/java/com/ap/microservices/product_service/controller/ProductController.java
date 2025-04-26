package com.ap.microservices.product_service.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.ap.microservices.product_service.dto.ProductRequest;
import com.ap.microservices.product_service.dto.ProductResponse;
import com.ap.microservices.product_service.model.Product;
import com.ap.microservices.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/product")
@RestController
public class ProductController {
    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
       return productService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.findAll();
    }

}
