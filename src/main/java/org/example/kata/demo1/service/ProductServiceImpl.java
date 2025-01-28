package org.example.kata.demo1.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.example.kata.demo1.model.Product;
import org.example.kata.demo1.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<Product> getProductsByPage(Pageable pageable) {
        // Obtenir tous les produits (par exemple depuis l'API externe ou une base de données)
        List<Product> allProducts = productRepository.findAll();

        // Déterminer le début et la fin des éléments selon la page demandée
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), allProducts.size());

        // Retourner la sous-liste paginée via un objet PageImpl
        return new PageImpl<>(allProducts.subList(start, end), pageable, allProducts.size());
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
