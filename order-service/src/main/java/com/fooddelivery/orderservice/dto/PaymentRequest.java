package com.fooddelivery.orderservice.dto;

import java.math.BigDecimal;

public class PaymentRequest {
    private Long orderId;
    private String userEmail;
    private BigDecimal amount;

    public PaymentRequest() {
    }

    public PaymentRequest(Long orderId, String userEmail, BigDecimal amount) {
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
