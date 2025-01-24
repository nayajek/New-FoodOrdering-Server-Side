package com.foodorder.dto;

import java.time.LocalDate;

public class OrderDetailsDto {

    private Long orderId;
    private String userName;
    private String userEmail;
    private String menuItemName;
    private LocalDate orderDate;
    private String status;
    private Double totalAmount;
    private String restaurantName; // Add this field

    public OrderDetailsDto(Long orderId, String userName, String userEmail, String menuItemName, LocalDate orderDate,
                           String status, Double totalAmount, String restaurantName) {
        this.orderId = orderId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.menuItemName = menuItemName;
        this.orderDate = orderDate;
        this.status = status;
        this.totalAmount = totalAmount;
        this.restaurantName = restaurantName;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getMenuItemName() {
        return menuItemName;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
