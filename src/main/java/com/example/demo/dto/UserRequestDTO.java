package com.example.demo.dto;

import java.util.List;
import jakarta.validation.constraints.*;

public class UserRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotEmpty(message = "Orders list cannot be empty")
    private List<OrderRequestDTO> orders;
    // getters & setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<OrderRequestDTO> getOrders() {
        return orders;
    }
    public void setOrders(List<OrderRequestDTO> orders) {
        this.orders = orders;
    }
}
