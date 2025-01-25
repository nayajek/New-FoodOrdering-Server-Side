package com.foodorder.repositories;

import com.foodorder.dto.OrderDetailsDto;
import com.foodorder.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("SELECT new com.foodorder.dto.OrderDetailsDto(o.id, COALESCE(u.name, 'Guest'), COALESCE(u.email, 'N/A'), COALESCE(m.name, 'Unknown Item'), o.orderDate, COALESCE(o.status, 'Pending'), o.totalAmount, COALESCE(r.name, 'Unknown Restaurant')) " +
            "FROM Orders o " +
            "LEFT JOIN Users u ON o.userId = u.id " +
            "LEFT JOIN Menu_Items m ON o.menuItemId = m.id " +
            "LEFT JOIN Restaurants r ON o.restaurantId = r.id") // Join Restaurants
    List<OrderDetailsDto> findOrderDetails();
}
