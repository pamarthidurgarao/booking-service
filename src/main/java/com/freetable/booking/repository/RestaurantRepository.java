package com.freetable.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freetable.booking.entity.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
