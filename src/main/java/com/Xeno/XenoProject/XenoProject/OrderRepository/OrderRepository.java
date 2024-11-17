package com.Xeno.XenoProject.XenoProject.OrderRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Xeno.XenoProject.XenoProject.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByCustomerId(Long id);
}