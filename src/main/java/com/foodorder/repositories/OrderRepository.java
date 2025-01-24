package com.foodorder.repositories;

import com.foodorder.dto.OrderDetailsDto;
import com.foodorder.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.foodorder.dto.OrderDetailsDto(o.id, u.name, u.email, m.name, o.orderDate, o.status, o.totalAmount, r.name) " +
            "FROM Orders o " +
            "JOIN Users u ON o.userId = u.id " +
            "JOIN Menu_Items m ON o.menuItemId = m.id " +
            "JOIN Restaurants r ON o.restaurantId = r.id") // Join Restaurants
    List<OrderDetailsDto> findOrderDetails();
}
