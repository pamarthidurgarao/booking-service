package com.freetable.freetablebookingservice.controller;

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

import com.freetable.freetablebookingservice.entity.TableEntity;
import com.freetable.freetablebookingservice.service.TableService;

@RestController
@RequestMapping("/api/v1/table")
public class TableController {

	@Autowired
	private TableService service;

	@PostMapping
	public ResponseEntity<TableEntity> create(@RequestBody TableEntity entity) {

		return new ResponseEntity<TableEntity>(service.create(entity), HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<TableEntity> get(@PathVariable String id) {

		return new ResponseEntity<TableEntity>(service.get(id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<TableEntity> delete(@PathVariable String id) {

		return new ResponseEntity<TableEntity>(service.get(id), HttpStatus.OK);
	}

	@GetMapping("search")
	public ResponseEntity<List<TableEntity>> search(@RequestParam Double lat, @RequestParam Double lang,
			@RequestParam Double distance) {

		return new ResponseEntity<List<TableEntity>>(service.search(lat, lang, distance), HttpStatus.OK);
	}

}
