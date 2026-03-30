package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.entity.Order;
import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.OrderRepository;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public Order createOrder(Order orderRequest) {

        // ✅ Fetch user from DB
        User user = userRepository.findById(orderRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ✅ Set user
        orderRequest.setUser(user);

        // ✅ Set initial status
        orderRequest.setStatus("CREATED");

        // ✅ Save order only (NO PAYMENT HERE)
        return orderRepository.save(orderRequest);
    }
}