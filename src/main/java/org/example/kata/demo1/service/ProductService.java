package org.example.kata.demo1.service;

import org.example.kata.demo1.model.Product;

import java.util.List;

public interface ProductService {


    long saveProducts(List<Product> productList);


    List<Product> getAllProducts();
}
