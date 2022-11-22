package store.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import store.productservice.dto.ProductRequest;
import store.productservice.dto.ProductResponse;
import store.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @GetMapping("/category/{category}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse getProductByCategory(@PathVariable String category) {
        return productService.getProductByCategory(category);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable String name) {
        productService.deleteProduct(name);
    }

}
