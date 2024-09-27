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

import com.springcloudapi.dto.UserDTO;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	@Autowired
    private RestTemplate restTemplate;

    private final String userServiceUrl = "http://localhost:8083/api/user";

    @GetMapping("/user/{name}")
    public UserDTO getUser(@PathVariable int name) {
        return restTemplate.getForObject(userServiceUrl + "/" + name, UserDTO.class);
    }

    @PostMapping("/user")
    public UserDTO createUser(@RequestBody UserDTO user) {
    	return restTemplate.postForObject(userServiceUrl, user, UserDTO.class);
    }
    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDTO user) {
        restTemplate.put(userServiceUrl + "/" + id, UserDTO.class);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {
        restTemplate.delete(userServiceUrl + "/" + id);
    }
}