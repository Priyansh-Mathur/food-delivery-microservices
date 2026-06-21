package com.fooddelivery.orderservice.client;

import com.fooddelivery.orderservice.dto.PaymentRequest;
import com.fooddelivery.orderservice.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {
    @PostMapping("/api/payments/create")
    PaymentResponse createPayment(@RequestBody PaymentRequest request);
}
