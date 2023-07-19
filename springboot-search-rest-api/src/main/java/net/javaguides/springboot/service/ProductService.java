package net.javaguides.springboot.service;

import lombok.RequiredArgsConstructor;
import net.javaguides.springboot.entity.Product;
import net.javaguides.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> searchProducts(String query) {

        return productRepository.searchProducts(query);
    }

    public Product createProduct(Product product) {

        return productRepository.save(product);
    }
}
