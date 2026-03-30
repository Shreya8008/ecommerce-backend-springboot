E-Commerce Backend System (Spring Boot)
# 🛒 E-Commerce Backend System

A **Spring Boot-based REST API backend** for an E-commerce application with authentication, product management, order processing, and payment simulation.

---

## 🚀 Features

### 👤 User Module
- User Registration
- User Login
- Role-based access (ADMIN / USER)
- Password stored securely (can be extended with BCrypt)

### 🔐 Authentication & Security
- JWT (JSON Web Token) based authentication
- Secure REST APIs using Spring Security
- Token-based authorization

### 📦 Product Module
- Add new products (Admin only)
- Update product details
- Delete products
- View all products
- Get product by ID

### 🛒 Order Module
- Create order for user
- Order status management (PENDING / COMPLETED)
- Link order with user

### 💳 Payment Module
- Payment processing simulation
- Payment status tracking (SUCCESS / FAILED)
- Linked with orders

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA
- Spring Security
- JWT Authentication
- Hibernate ORM
- PostgreSQL / MySQL
- Maven

---

## 🏗️ Project Architecture

The project follows **Layered Architecture**:


Controller Layer → Service Layer → Repository Layer → Database


### Layers:
- **Controller** → Handles API requests
- **Service** → Business logic
- **Repository** → Database operations
- **Entity** → Database models

---

## 📁 Project Structure


src/main/java/com/ecommerce/ecommerce_backend/

├── controller
│ ├── UserController.java
│ ├── ProductController.java
│ ├── OrderController.java
│ └── PaymentController.java
│
├── service
│ ├── UserService.java
│ ├── ProductService.java
│ ├── OrderService.java
│ └── PaymentService.java
│
├── repository
│ ├── UserRepository.java
│ ├── ProductRepository.java
│ ├── OrderRepository.java
│ └── PaymentRepository.java
│
├── entity
│ ├── User.java
│ ├── Product.java
│ ├── Order.java
│ └── Payment.java
│
├── security
│ ├── JwtUtil.java
│ ├── JwtFilter.java
│ └── SecurityConfig.java
│
└── EcommerceBackendApplication.java


---

## 🔌 API Endpoints

### 👤 User APIs

POST /api/users/register → Register user
POST /api/auth/login → Login user


### 📦 Product APIs

GET /api/products → Get all products
GET /api/products/{id} → Get product by ID
POST /api/products → Add product
PUT /api/products/{id} → Update product
DELETE /api/products/{id} → Delete product


### 🛒 Order APIs

POST /api/orders → Create order
GET /api/orders/{id} → Get order details


### 💳 Payment APIs

POST /api/payments/{orderId} → Process payment


---

## 🔐 JWT Authentication Flow

1. User registers / logs in
2. Server generates JWT token
3. Client sends token in header:

Authorization: Bearer <token>

4. Server validates token before processing requests

---

## 🗄️ Database Schema

### User Table
- id
- name
- email (unique)
- password
- role

### Product Table
- id
- name
- description
- price
- stock

### Order Table
- id
- user_id (FK)
- total_amount
- status

### Payment Table
- id
- order_id (FK)
- amount
- status
- method

---

## ▶️ How to Run Project

### 1. Clone repository

git clone https://github.com/your-username/ecommerce-backend.git


### 2. Open in IDE
- IntelliJ IDEA / Eclipse

### 3. Configure Database
Update in `application.properties`:

spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=postgres
spring.datasource.password=yourpassword


### 4. Run Application

mvn spring-boot:run


### 5. Access Swagger UI

http://localhost:8080/swagger-ui/index.html


---

## 🧪 Testing Tools Used

- Postman
- Swagger UI

---

## 📌 Future Improvements

- Frontend (React / Angular)
- Payment gateway integration (Razorpay / Stripe)
- Email notifications
- Cart module
- Microservices architecture

---

## 👨‍💻 Author

**Shreya Dilip Chougule**

- GitHub: https://github.com/your-username
- Project: Spring Boot E-commerce Backend

---
