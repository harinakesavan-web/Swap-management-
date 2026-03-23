package com.example.demo.controller;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER + ORDERS
    @PostMapping
    public User createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable @Min(1) Long id) {
        System.out.println("Controller Test");
        return userService.getUserById(id);
    }

    // GET ALL USERS

    @GetMapping("/ping")
    public String ping() {
        return "PING OK";
    }

    //@GetMapping
    //public List<User> getAllUsers() {
    //    return userService.getAllUsers();
    //}

    // UPDATE USER
    @PutMapping("/{id}")
    public String updateUser(
            @PathVariable @Min(1) Long id,
            @Valid @RequestBody UserRequestDTO dto) {

        System.out.println("Controller Test");
        return "CONTROLLER HIT";
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
