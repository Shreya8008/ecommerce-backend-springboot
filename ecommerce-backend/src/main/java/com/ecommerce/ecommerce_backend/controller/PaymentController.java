package com.ecommerce.ecommerce_backend.controller;

import com.ecommerce.ecommerce_backend.entity.Payment;
import com.ecommerce.ecommerce_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    // ✅ Process payment for an order
    @PostMapping("/{orderId}")
    public Payment makePayment(@PathVariable Long orderId,
                               @RequestBody Payment payment) {
        return paymentService.processPayment(orderId, payment);
    }
}