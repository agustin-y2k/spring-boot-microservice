package store.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import store.productservice.dto.ProductRequest;
import store.productservice.dto.ProductResponse;
import store.productservice.model.Product;
import store.productservice.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse getProductByName(String name) {
        Product product = productRepository.findByName(name);
        return mapToProductResponse(product);
    }

    public  ProductResponse getProductByCategory(String category) {
        Product product = productRepository.findByCategory(category);
        return mapToProductResponse(product);
    }

    public void createProduct(ProductRequest productRequest) {
        if (productRepository.findByName(productRequest.getName()) != null) {
            throw new IllegalArgumentException("Product with name " + productRequest.getName() + " already exists");
        } else {
            Product product = Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .category(productRequest.getCategory())
                    .price(productRequest.getPrice())
                    .build();

            productRepository.save(product);
            log.info("Product {} is saved", product.getName());
        }
    }

    public void deleteProduct(String name) {
        productRepository.deleteByName(name);
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .price(product.getPrice())
                .build();
    }
}
