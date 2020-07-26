package com.freetable.booking.service;

import java.util.List;

import com.freetable.booking.entity.Restaurant;

public interface RestaurantService {

	List<Restaurant> getAll();

	Restaurant create(Restaurant restaurant);

	Restaurant get(String id);

	void delete(String id);
}
