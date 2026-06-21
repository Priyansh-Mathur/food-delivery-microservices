package com.fooddelivery.orderservice.service;

import com.fooddelivery.orderservice.client.PaymentClient;
import com.fooddelivery.orderservice.client.RestrauntClient;
import com.fooddelivery.orderservice.client.UserClient;
import com.fooddelivery.orderservice.dto.CreateOrderRequest;
import com.fooddelivery.orderservice.dto.MenuItemResponse;
import com.fooddelivery.orderservice.dto.PaymentRequest;
import com.fooddelivery.orderservice.dto.PaymentResponse;
import com.fooddelivery.orderservice.entity.FoodOrder;
import com.fooddelivery.orderservice.entity.OrderStatus;
import com.fooddelivery.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;
    private final RestrauntClient restrauntClient;
    private final PaymentClient paymentClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient, RestrauntClient restrauntClient, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
        this.restrauntClient = restrauntClient;
        this.paymentClient = paymentClient;
    }

    public FoodOrder createOrder(String userEmail, CreateOrderRequest request) {
        userClient.getUserByEmail(userEmail);

        MenuItemResponse menuItem = restrauntClient.getMenuItem(request.getMenuItemId());

        if (!Boolean.TRUE.equals(menuItem.getAvailable())) {
            throw new RuntimeException("Menu item is not available");
        }

        if (!menuItem.getRestrauntId().equals(request.getRestrauntId())) {
            throw new RuntimeException("Menu item does not belong to this restraunt");
        }

        BigDecimal totalAmount = menuItem.getPrice().multiply(BigDecimal.valueOf(request.getQuantity()));

        FoodOrder order = new FoodOrder();
        order.setUserEmail(userEmail);
        order.setRestrauntId(request.getRestrauntId());
        order.setMenuItemId(request.getMenuItemId());
        order.setItemName(menuItem.getName());
        order.setQuantity(request.getQuantity());
        order.setTotalAmount(totalAmount);
        order.setOrderStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        FoodOrder savedOrder = orderRepository.save(order);

        PaymentResponse paymentResponse = paymentClient.createPayment(
                new PaymentRequest(savedOrder.getId(), userEmail, totalAmount)
        );

        savedOrder.setPaymentId(paymentResponse.getPaymentId());
        savedOrder.setPaymentStatus(paymentResponse.getStatus());

        return orderRepository.save(savedOrder);
    }

    public List<FoodOrder> getMyOrders(String userEmail) {
        return orderRepository.findByUserEmail(userEmail);
    }

    public FoodOrder getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
