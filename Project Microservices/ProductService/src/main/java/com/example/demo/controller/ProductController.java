package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import jakarta.annotation.Resource;
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = new Product(id, "Laptop", 1000.0);
        return ResponseEntity.ok(product);
    }
	 
	 
}
