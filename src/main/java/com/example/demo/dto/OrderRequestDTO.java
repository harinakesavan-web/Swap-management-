package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class OrderRequestDTO {

    @NotBlank(message = "Product is required")
    private String product;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    // getters & setters
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}

