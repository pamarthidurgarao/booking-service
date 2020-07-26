package com.freetable.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freetable.booking.entity.Restaurant;
import com.freetable.booking.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository repository;

	@Override
	public Restaurant create(Restaurant entity) {
		return repository.save(entity);
	}

	@Override
	public Restaurant get(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

	@Override
	public List<Restaurant> getAll() {
		return repository.findAll();
	}

}
