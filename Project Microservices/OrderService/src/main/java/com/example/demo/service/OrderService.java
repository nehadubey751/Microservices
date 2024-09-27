package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;

@Service
public class OrderService {
	   
	@Autowired
	    private RestTemplate restTemplate;

	    @Autowired
	    private ProductRepository productRepository;

	    public Product getProductById(Long id) {
	        // Fetch product from another service
	        String url = "http://localhost:8082/product/" + id;
	        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
	        
	        if (response.getStatusCode().is2xxSuccessful()) {
	            return response.getBody();
	        }
	        return null; 
	    }

	    public Product createProduct(Product product) {
	        // Save the product using the repository
	        return productRepository.save(product); // Assuming productRepository is set up correctly
	    }
	}	   


