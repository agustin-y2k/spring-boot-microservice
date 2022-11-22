package store.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import store.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByName(String name);
    Product findByCategory(String category);
    Product deleteByName(String name);
}
