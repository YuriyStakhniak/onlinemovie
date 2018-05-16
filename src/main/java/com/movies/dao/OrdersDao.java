package com.movies.dao;


import org.springframework.data.jpa.repository.JpaRepository;


import com.movies.entity.Orders;


public interface OrdersDao extends JpaRepository<Orders, Integer>{
	

}
