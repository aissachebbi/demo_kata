package org.example.kata.demo1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.kata.demo1.dto.ProductResponse;
import org.example.kata.demo1.model.Product;
import org.example.kata.demo1.service.ProductService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/kata/v1/test")
public class SimpleController {
    public SimpleController(ProductService productService, WebClient webClient) {
        this.productService = productService;
        this.webClient = webClient;
    }

    private final ProductService productService;
    private final WebClient webClient;

    private List<Product> getAllProduct() throws JsonProcessingException {
        final String uri = "https://jsonmock.hackerrank.com/api/inventory";
        String result = webClient.get().uri(uri).retrieve().bodyToMono(String.class).block();
        JSONObject root = new JSONObject(result);

        JSONArray data = root.getJSONArray("data");
        ObjectMapper objectMapper = new ObjectMapper();
        Product[] ProductArray = objectMapper.readValue(data.toString(), Product[].class);
        return Arrays.asList(ProductArray);
    }


    @GetMapping("/getAllProduct")
    public List<Product> listAllProduct() throws JsonProcessingException {
        return getAllProduct();
    }

    @PostMapping()
    public ProductResponse saveAll() throws JsonProcessingException {
        List<Product> ProductList = getAllProduct();
        long productSaved = productService.saveProducts(ProductList);
        return new ProductResponse(productSaved);
    }


}
