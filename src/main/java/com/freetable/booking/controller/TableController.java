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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freetable.booking.entity.Table;
import com.freetable.booking.service.TableService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/v1/table")
@Api(tags = "Table API")
public class TableController {

	@Autowired
	private TableService service;

	@PostMapping
	public ResponseEntity<Table> create(@RequestBody Table entity) {

		return new ResponseEntity<Table>(service.create(entity), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Table> get(@PathVariable String id) {

		return new ResponseEntity<Table>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Table> delete(@PathVariable String id) {

		return new ResponseEntity<Table>(service.get(id), HttpStatus.OK);
	}

	@GetMapping("search")
	public ResponseEntity<List<Table>> search(@RequestParam Double lat, @RequestParam Double lang,
			@RequestParam Double distance) {

		return new ResponseEntity<List<Table>>(service.search(lat, lang, distance), HttpStatus.OK);
	}

}
