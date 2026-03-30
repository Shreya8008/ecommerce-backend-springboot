package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.entity.User;
import com.ecommerce.ecommerce_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // ✅ REGISTER
    public User register(User user) {

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        } else {
            user.setRole("ROLE_" + user.getRole()); // 🔥 IMPORTANT
        }

        return userRepository.save(user);
    }

    // ✅ GET ALL USERS (🔥 FIX)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}