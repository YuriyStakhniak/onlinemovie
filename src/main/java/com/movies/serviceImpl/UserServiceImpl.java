package com.movies.serviceImpl;

import java.security.Principal;
import java.util.List;

import com.movies.dao.MovieDao;
import com.movies.entity.Movie;
import com.movies.entity.Role;
import com.movies.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.movies.dao.UserDao;
import com.movies.entity.User;
import com.movies.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private MovieDao movieDao;

	@Autowired
	@Qualifier("userValidator")
	Validator validator;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void save(User user) throws Exception {
		validator.validate(user);
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));
		userDao.save(user);
	}

	public List<User> findAll() {

		return userDao.findAll();
	}

	public User findOne(int id) {
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.save(user);

	}

	@Override
	public User findByUuid(String uuid) {
		return userDao.findByUuid(uuid);
	}

	@Override
	public User findUserWithOrders(int id) {
		return userDao.findUserWithOrders(id);
	}

	@Override
	public User findUserWithMovies(int id) {

		User user = userDao.findUserWithMovies(id);
		User returnUser = new User();
		returnUser.setId(id);
		returnUser.setName(user.getName());


		for (int i = 0; i < user.getMovies().size(); i++){

			Movie movie = new Movie(user.getMovies().get(i).getId(), user.getMovies().get(i).getTitle(),
					user.getMovies().get(i).getImdbRating(), user.getMovies().get(i).getDescription(),
					user.getMovies().get(i).getYear());
			movie.setPathImage(user.getMovies().get(i).getPathImage());

			returnUser.getMovies().add(movie);
		}

		int counter = 0;

		for (Movie movie: user.getMovies()) {

			returnUser.getMovies().get(counter).
					setDirectors(movieDao.findMovieWithDirectors(movie.getId()).getDirectors());
			returnUser.getMovies().get(counter).
					setStars(movieDao.findMovieWithStars(movie.getId()).getStars());
			returnUser.getMovies().get(counter)
					.setGenres(movieDao.findMovieWithGenres(movie.getId()).getGenres());
			counter++;
		}
		return returnUser;
	}

	@Override
	public User findUserByNameWithMovies(String name) {
		return userDao.findUserByNameWithMovies(name);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return userDao.findByName(s);
	}

}
