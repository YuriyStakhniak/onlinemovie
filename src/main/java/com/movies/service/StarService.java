package com.movies.service;

import java.util.List;


import com.movies.entity.Star;
import org.springframework.web.multipart.MultipartFile;

public interface StarService {
	
	void save(Star star, MultipartFile image) throws Exception;

	List<Star> findAll();

	Star findOne(int id);

	void delete(int id);

	void update(Star star, MultipartFile image) throws Exception;

	List<Star> starsWithMovies();

}
