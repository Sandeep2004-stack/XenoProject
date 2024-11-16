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

    // Add a new order
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get orders for a specific customer
    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getCustomer().getId().equals(customerId))
                .toList(); // Replace with repository query if required
    }
}
