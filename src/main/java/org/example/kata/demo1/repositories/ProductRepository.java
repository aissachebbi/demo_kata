package org.example.kata.demo1.repositories;

import org.example.kata.demo1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
