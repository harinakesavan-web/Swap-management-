package com.example.demo.service;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.entity.Order;
import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.OrderRequestDTO;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CREATE
    public User createUser(UserRequestDTO dto) {

        User user = new User();
        user.setName(dto.getName());

        int i = 0;

        while(dto.getOrders().size() > i){
            Order order = new Order();
            //List <OrderRequestDTO> orderRequestDTO = Collections.singletonList(dto.getOrders().get(i));
            OrderRequestDTO orderRequestDTO = dto.getOrders().get(i);
            order.setProduct(orderRequestDTO.getProduct());
            order.setPrice(orderRequestDTO.getPrice());
            user.addOrder(order);
            i++;
            //     order.setPrice(o.getPrice());
        }
       // for (OrderRequestDTO o : dto.getOrders()) {
       //     Order order = new Order();
       //     order.setProduct(o.getProduct());
       //     order.setPrice(o.getPrice());

       //     user.addOrder(order);
        // }

        return userRepository.save(user);
    }

    // READ
    public User getUserById(Long id) {
        System.out.println("Controller Test1");
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // READ ALL
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    public User updateUser(Long id, UserRequestDTO dto) {
        System.out.println("BREAKPOINT UPDATE TEST");
        User user = getUserById(id);
        user.setName(dto.getName());

        // clear old orders
        user.getOrders().clear();

        // add new orders
        for (OrderRequestDTO o : dto.getOrders()) {
            Order order = new Order();
            order.setProduct(o.getProduct());
            order.setPrice(o.getPrice());
            user.addOrder(order);
        }

        return userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

