package com.todo.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	//GET /users
	//retrieveAllUsers
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll(); 
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-"+id);
		}
		
		return user;
	}
	
	//input - details of user
	//output - CREATED & Return the created URI
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		User savedUser = service.save(user);
		// CREATED
		// /user/{id} saveUser.getID
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	

}