package com.movies.service;

import java.security.Principal;
import java.util.List;

import com.movies.entity.Orders;

public interface OrdersService {


	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	void addToCart(Principal principal, int id);

	void deleteFromCart(int userId, int drinkId);

	void buy(int userId);
	

}
