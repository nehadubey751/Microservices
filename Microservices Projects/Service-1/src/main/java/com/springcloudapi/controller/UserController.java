package com.springcloudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloudapi.entity.User;
import com.springcloudapi.repo.Userrepo;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private Userrepo userrepo;
	
	@PostMapping
	public User  save(@RequestBody User user) {
		return userrepo.save(user);
	}
	  
	@GetMapping
	   public List<User> getAll() {
	    return userrepo.findAll();
	    }
 
	@GetMapping("{id}")
	public  User get(@PathVariable int id) {
		return userrepo.findById(id).orElse(null);
		
	}
	 @PutMapping("{id}")
	    public User update(@PathVariable int id, @RequestBody User userDetails) {
	        return userrepo.findById(id).map(user -> {
	            user.setName(userDetails.getName());
	            user.setId(userDetails.getId());
	            return userrepo.save(user);
	        }).orElse(null);
	    }
	 
     @DeleteMapping("{id}")
	    public String delete(@PathVariable int id) {
	        return userrepo.findById(id).map(user -> {
	            userrepo.delete(user);
	           return "User deleted successfully!";
	        }).orElse("User not found!");
	    }
	}
