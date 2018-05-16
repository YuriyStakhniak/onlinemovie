package com.movies.service;

import java.security.Principal;
import java.util.List;

import com.movies.entity.User;

public interface UserService {
	
	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

	User findByUuid(String uuid);

	User findUserWithOrders(int id);

	User findUserWithMovies(int id);

	User findUserByNameWithMovies(String username);

}
