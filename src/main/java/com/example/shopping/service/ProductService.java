package com.example.shopping.service;

import com.example.shopping.model.Product;
import com.example.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    /**
     * Add some products
     */
    @PostConstruct
    private void addProducts() {
        Stream.of(
                "Pen,This is pen description,,P01,10",
                "Eraser,This is eraser description,,P02,15"
        ).map(product -> {
            var productDetails = product.split(",");
            var newProduct = new Product();
            newProduct.setName(productDetails[0]);
            newProduct.setDescription(productDetails[1]);
            newProduct.setCode(productDetails[3]);
            newProduct.setPrice(Float.parseFloat(productDetails[4]));
            return newProduct;
        }).forEach(productRepository::save);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
