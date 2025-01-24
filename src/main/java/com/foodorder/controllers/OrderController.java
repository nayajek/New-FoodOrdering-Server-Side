package com.foodorder.controllers;

import com.foodorder.dto.OrderDetailsDto;
import com.foodorder.models.Orders;
import com.foodorder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    // Create a new order
    @PostMapping(path = "/add")
    public @ResponseBody Orders addNewOrder(@RequestBody Orders order) {
        return orderRepository.save(order);
    }

    // Read all order details
    @GetMapping("/all")
    public List<OrderDetailsDto> getOrderDetails() {
        return orderRepository.findOrderDetails();
    }

    // Read a specific order by ID
    @GetMapping(path = "/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Optional<Orders> order = orderRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an order by ID
    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Long id, @RequestBody Orders updatedOrder) {
        return orderRepository.findById(id).map(order -> {
            order.setOrderDate(updatedOrder.getOrderDate());
            order.setStatus(updatedOrder.getStatus());
            order.setTotalAmount(updatedOrder.getTotalAmount());
            return ResponseEntity.ok(orderRepository.save(order));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete an order by ID
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

