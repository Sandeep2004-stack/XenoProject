package com.Xeno.XenoProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Xeno.XenoProject.Entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomerId(Long id);
}