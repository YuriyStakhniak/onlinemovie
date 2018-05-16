package com.movies.dao;



import com.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import com.movies.entity.Director;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DirectorDao extends JpaRepository<Director, Integer> {
	@Query("select distinct d from Director d left join fetch d.movies")
    List<Director> directorsWithMovies();

    @Query("select d from Director d left join fetch d.movies where d.id=:id")
    Director directorWithMovies(@Param("id") int id);

    Director findByName(String name);
    Director findByMovies(List<Movie> movies);
}
