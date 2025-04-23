package com.ap.microservices.product_service.service;

import com.ap.microservices.product_service.dto.ProductRequest;
import com.ap.microservices.product_service.dto.ProductResponse;
import com.ap.microservices.product_service.model.Product;
import com.ap.microservices.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest productRequest){

    Product product = Product.builder().name(productRequest.name())
            .description(productRequest.description())
            .price(productRequest.price()).build();
        productRepository.save(product);
        log.info("Product created successfully..");
        return new ProductResponse(product.getName(),product.getDescription(),product.getPrice());
}

    public List<ProductResponse> findAll(){
        List<Product> productList=productRepository.findAll();
        log.info("Product fetched successfully..");
        return productList.stream().map(product-> new ProductResponse(product.getName(),product.getDescription(),product.getPrice())).toList();

    }
}
