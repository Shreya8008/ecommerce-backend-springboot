package com.ecommerce.ecommerce_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;

    // ✅ GETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {   // 🔥 IMPORTANT
        return email;
    }

    public String getPassword() {   // 🔥 IMPORTANT
        return password;
    }

    public String getRole() {
        return role;
    }

    // ✅ SETTERS

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {   // 🔥 IMPORTANT
        this.email = email;
    }

    public void setPassword(String password) {   // 🔥 IMPORTANT
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }
}