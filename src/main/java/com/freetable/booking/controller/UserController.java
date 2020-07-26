package com.freetable.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freetable.booking.entity.User;
import com.freetable.booking.service.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User API")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public ResponseEntity<User> create(@RequestBody User entity) {
		return new ResponseEntity<User>(service.create(entity), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<User> get(@PathVariable String id) {
		return new ResponseEntity<User>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(service.getAll(), HttpStatus.OK);
	}

}
