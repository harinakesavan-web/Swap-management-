package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One User -> Many Orders
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Order> orders = new ArrayList<>();

    // helper methods (VERY IMPORTANT)
    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this); // link child to parent
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }

    public  Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Order> getOrders() {
        return orders;
    }

}

