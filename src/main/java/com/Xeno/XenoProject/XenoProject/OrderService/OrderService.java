package com.Xeno.XenoProject.XenoProject.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.XenoProject.OrderRepository.OrderRepository;
import com.Xeno.XenoProject.XenoProject.order.Order;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order) {
    	return orderRepository.save(order);
    }
    
    public List<Order> getAllOrders() {
    	return orderRepository.findAll();
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    } 
}
