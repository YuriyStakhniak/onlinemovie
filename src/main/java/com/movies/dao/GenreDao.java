package com.movies.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.entity.Genre;



public interface GenreDao extends JpaRepository<Genre, Integer> {


        Genre findByName(String name);
	

}
