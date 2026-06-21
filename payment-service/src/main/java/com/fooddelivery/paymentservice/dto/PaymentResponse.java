package com.fooddelivery.paymentservice.dto;

import java.math.BigDecimal;

public class PaymentResponse {
    private Long paymentId;
    private Long orderId;
    private String userEmail;
    private BigDecimal amount;
    private String status;

    public PaymentResponse() {
    }

    public PaymentResponse(Long paymentId, Long orderId, String userEmail, BigDecimal amount, String status) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.userEmail = userEmail;
        this.amount = amount;
        this.status = status;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
