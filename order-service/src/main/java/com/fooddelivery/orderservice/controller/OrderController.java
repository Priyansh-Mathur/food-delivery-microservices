package com.fooddelivery.orderservice.controller;

import com.fooddelivery.orderservice.dto.CreateOrderRequest;
import com.fooddelivery.orderservice.entity.FoodOrder;
import com.fooddelivery.orderservice.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public FoodOrder createOrder(@RequestHeader("X-User-Email") String userEmail,
                                 @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(userEmail, request);
    }

    @GetMapping("/my-orders")
    public List<FoodOrder> getMyOrders(@RequestHeader("X-User-Email") String userEmail) {
        return orderService.getMyOrders(userEmail);
    }

    @GetMapping("/{orderId}")
    public FoodOrder getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }
}
