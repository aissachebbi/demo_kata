package org.example.kata.demo1.service;

import org.example.kata.demo1.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {


    long saveProducts(List<Product> productList);

     Page<Product> getProductsByPage (Pageable pageable);
    List<Product> getAllProducts();
}
