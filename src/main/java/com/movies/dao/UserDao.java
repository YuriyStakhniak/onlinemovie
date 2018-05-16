package com.movies.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movies.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findByEmail (String email);


    @Query("select u from User u where u.uuid =:uuid")
    User findByUuid(@Param("uuid") String uuid);

    @Query("select u from User u left join fetch u.movies where u.id=:id")
    User findUserWithMovies(@Param("id") int id);


    @Query("select distinct u from User u left join fetch u.movies where u.name=:name")
    User findUserByNameWithMovies(@Param("name") String name);

    @Query("select u from User u left join fetch u.orders o left join fetch o.movies where u.id=:id")
    User findUserWithOrders(@Param("id") int id);
	


}
