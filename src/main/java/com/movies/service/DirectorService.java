package com.movies.service;

import java.util.ArrayList;
import java.util.List;

import com.movies.entity.Director;
import org.springframework.web.multipart.MultipartFile;


public interface DirectorService {
	void save(Director director, String name, String about, MultipartFile image) throws Exception;

	List<Director> findAll();

	Director findOne(int id);

	void delete(int id) throws Exception;


    void update(Director director, String name, String about, MultipartFile image) throws Exception;

    List<Director> directorsWithMovies();

	Director directorWithMovies(int id);

}
