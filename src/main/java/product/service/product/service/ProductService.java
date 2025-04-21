package product.service.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import product.service.product.dto.ProductRequest;
import product.service.product.dto.ProductResponse;
import product.service.product.model.Product;
import product.service.product.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product  product=Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);

        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProduct(){
        List<Product> productList=productRepository.findAll();
        return productList.stream().map(this::getProductResponse).toList();
    }

    private ProductResponse getProductResponse(Product product){
       return  ProductResponse.builder().description(product.getDescription())
                .name(product.getName()).price(product.getPrice()).build();
    }
}
