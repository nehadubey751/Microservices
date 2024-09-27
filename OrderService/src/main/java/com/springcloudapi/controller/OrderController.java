package com.springcloudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
    private RestTemplate restTemplate;

    private final String userServiceUrl = "http://localhost:8081/api/user";

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        // Using getForObject
        return restTemplate.getForObject(userServiceUrl + "/" + id, String.class);
    }

    @PostMapping("/user")
    public Long createUser(@RequestBody String user) {
        // Using postForObject
        return restTemplate.postForObject(userServiceUrl, user, Long.class);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody String user) {
        // Using put
        restTemplate.put(userServiceUrl + "/" + id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        // Using delete
        restTemplate.delete(userServiceUrl + "/" + id);
    }
}