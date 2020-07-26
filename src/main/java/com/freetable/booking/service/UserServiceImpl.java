package com.freetable.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freetable.booking.entity.User;
import com.freetable.booking.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAll() {
		return repository.findAll();
	}

	@Override
	public User create(User user) {
		return repository.save(user);
	}

	@Override
	public User get(String id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public void delete(String id) {
		repository.deleteById(id);
	}

}
