package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private double price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id") // FK column
    private User user;

    // getters & setters

    public void setId(Long id) {
        this.id = id;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getId() {
        return id;
    }
    public String getProduct() {
        return product;
    }
    public double getPrice() {
        return price;
    }
    public User getUser() {
        return user;
    }
}
