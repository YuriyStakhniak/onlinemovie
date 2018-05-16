package com.movies.service;

import java.util.ArrayList;
import java.util.List;


import com.movies.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


public interface MovieService {


	
	void save(Movie movie, ArrayList<Integer> genresId,
			  ArrayList<Integer> starsId, MultipartFile image, ArrayList<Integer> directorsId) throws Exception;
	List<Movie> findAll();
	Movie findOne(int id);
	void delete(int id);
	void update(Movie movie, String title, ArrayList<Integer> genresId,
				ArrayList<Integer> starsId, String year, String imdbRating, String description, MultipartFile image, ArrayList<Integer> directorsId) throws Exception;
	List<Movie> moviesWithGenres();
	List<Movie> moviesWithStars();
	List<Movie> movieWithGenresAndStars();
	List<Movie> moviesWithGenresAndStarsAndDirectors();
	List<Movie> moviesWithDirectors();
	Page<Movie> findAllPages(Pageable pageable);
	Movie findMovieWithStars(int id);
	Movie findMovieWithGenresAndStars(int id);
	Movie findMovieWithDirectors(int id);
	Movie findMovieWithDirectorsAndMoviesAndStars(int id);

	Movie findMovieWithGenres(int id);


}
