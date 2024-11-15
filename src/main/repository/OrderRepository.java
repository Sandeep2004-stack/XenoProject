package com.Xeno.XenoProject.XenoProject.OrderRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Xeno.XenoProject.XenoProject.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}