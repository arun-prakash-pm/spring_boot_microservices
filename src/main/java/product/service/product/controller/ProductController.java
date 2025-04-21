package product.service.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import product.service.product.dto.ProductRequest;
import product.service.product.dto.ProductResponse;
import product.service.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

private  final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
       return productService.getAllProduct();
    }
}
