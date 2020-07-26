package com.freetable.booking.service;

import java.util.List;

import com.freetable.booking.entity.User;

public interface UserService {

	List<User> getAll();

	User create(User user);

	User get(String id);

	void delete(String id);
}
