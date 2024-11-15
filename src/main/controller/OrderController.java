package com.Xeno.XenoProject.XenoProject.OrderController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Xeno.XenoProject.XenoProject.OrderRepository.OrderRepository;
import com.Xeno.XenoProject.XenoProject.order.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}
