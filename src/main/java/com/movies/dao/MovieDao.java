package com.movies.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.movies.entity.Movie;
import org.springframework.data.repository.query.Param;


public interface MovieDao extends JpaRepository<Movie, Integer> {

	@Query("select distinct m from Movie m left join fetch m.genres")
	List<Movie> moviesWithGenres();
	@Query("select  distinct m from Movie m left join fetch m.stars")
	List<Movie> moviesWithStars();
	@Query("select distinct m from Movie m left join fetch m.directors")
	List<Movie> moviesWithDirectors();

	Movie findByTitle(String title);

	@Query("select m from Movie m left join fetch m.directors where m.id=:id")
	Movie findMovieWithDirectors(@Param("id") int id);
	@Query("select m from Movie m left join fetch m.genres where m.id=:id")
	Movie findMovieWithGenres(@Param("id") int id);
	@Query("select m from Movie m left join fetch m.stars where m.id=:id")
	Movie findMovieWithStars(@Param("id") int id);

	@Query("select distinct m from Movie m left join fetch m.users where m.id=:id")
	Movie moviesWithUsers(@Param("id") int id);

}
