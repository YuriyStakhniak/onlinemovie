package com.movies.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import com.movies.dao.MovieDao;
import com.movies.dao.OrdersDao;
import com.movies.dao.UserDao;
import com.movies.entity.Movie;
import com.movies.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.entity.Orders;
import com.movies.service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService {


	@Autowired
	private UserDao userDao;
	@Autowired
	private MovieDao movieDao;
	@Autowired
	private OrdersDao ordersDao;
	
	public void save(Orders orders) {
		ordersDao.save(orders);
	}

	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
		
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
		
	}

    @Override
    public void addToCart(Principal principal, int id) {

            User user = userDao.findUserWithMovies(Integer.parseInt(principal.getName()));

            Movie movie = movieDao.findOne(id);
            user.getMovies().add(movie);

            userDao.save(user);


    }

	@Override
	@Transactional
	public void deleteFromCart(int userId, int drinkId) {

		User user = userDao.findUserWithMovies(userId);

		Movie movie = movieDao.moviesWithUsers(drinkId);

		user.getMovies().remove(movie);

		userDao.save(user);


	}

	@Override
	@Transactional
	public void buy(int userId) {

		Orders orders = new Orders(LocalDate.now());
		ordersDao.saveAndFlush(orders);
		User user = userDao.findUserWithMovies(userId);
		orders.setUser(user);

		for (Movie movie : user.getMovies()) {

			orders.getMovies().add(movie);
			ordersDao.save(orders);

		}

		user.getMovies().clear();
		userDao.save(user);


	}


}
