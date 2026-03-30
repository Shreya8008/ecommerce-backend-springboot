package com.ecommerce.ecommerce_backend.service;

import com.ecommerce.ecommerce_backend.entity.Order;
import com.ecommerce.ecommerce_backend.entity.Payment;
import com.ecommerce.ecommerce_backend.repository.OrderRepository;
import com.ecommerce.ecommerce_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Payment processPayment(Long orderId, Payment paymentRequest) {

        // ✅ Fetch order
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // ✅ Set payment details
        paymentRequest.setOrder(order);
        paymentRequest.setAmount(order.getTotalAmount());
        paymentRequest.setStatus("SUCCESS");
        paymentRequest.setTransactionId(UUID.randomUUID().toString());

        // ✅ Save payment
        Payment savedPayment = paymentRepository.save(paymentRequest);

        // 🔥 IMPORTANT: Update order status
        order.setStatus("COMPLETED");
        orderRepository.save(order);

        return savedPayment;
    }
}