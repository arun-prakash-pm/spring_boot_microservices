package product.service.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import product.service.product.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
