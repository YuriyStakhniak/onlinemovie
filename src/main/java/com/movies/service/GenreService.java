package com.movies.service;

import java.util.List;

import com.movies.entity.Genre;
import com.movies.entity.Movie;


public interface GenreService {
	
		void save(Genre genre) throws Exception;

		List<Genre> findAll();

		Genre findOne(int id);

		void delete(int id);

		void update(Genre genre) throws Exception;


}
