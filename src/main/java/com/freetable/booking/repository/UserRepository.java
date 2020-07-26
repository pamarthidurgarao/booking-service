package com.freetable.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.freetable.booking.entity.User;

public interface UserRepository extends MongoRepository<User, String> {
}
