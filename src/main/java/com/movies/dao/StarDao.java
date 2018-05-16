package com.movies.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.entity.Movie;
import com.movies.entity.Star;
import org.springframework.data.jpa.repository.Query;

public interface StarDao extends JpaRepository<Star, Integer> {
	
        Star findByName(String name);

        @Query("select s from Star s left join fetch s.movies")
        List<Star> starsWithMovies();

}
