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

import com.freetable.booking.entity.Restaurant;
import com.freetable.booking.service.RestaurantService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/restaurant")
@Api(tags = "Restaurant API")
public class RestaurantController {

	@Autowired
	private RestaurantService service;

	@PostMapping
	public ResponseEntity<Restaurant> create(@RequestBody Restaurant entity) {

		return new ResponseEntity<Restaurant>(service.create(entity), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Restaurant> get(@PathVariable String id) {

		return new ResponseEntity<Restaurant>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<Restaurant>> getAll() {
		return new ResponseEntity<List<Restaurant>>(service.getAll(), HttpStatus.OK);
	}

}
