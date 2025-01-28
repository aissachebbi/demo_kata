package org.example.kata.demo1.service;

import lombok.RequiredArgsConstructor;
import org.example.kata.demo1.model.Product;
import org.example.kata.demo1.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public long saveProducts(List<Product> productList) {
        return productRepository.saveAll(productList)
                .size();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
