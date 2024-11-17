package com.Xeno.XenoProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Xeno.XenoProject.Entity.Order;
import com.Xeno.XenoProject.Repository.OrderRepository;


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
