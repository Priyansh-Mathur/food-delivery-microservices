package com.fooddelivery.orderservice.repository;

import com.fooddelivery.orderservice.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findByUserEmail(String userEmail);
}
