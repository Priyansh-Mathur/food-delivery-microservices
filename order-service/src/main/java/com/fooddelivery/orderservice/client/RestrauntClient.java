package com.fooddelivery.orderservice.client;

import com.fooddelivery.orderservice.dto.MenuItemResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTRAUNT-SERVICE")
public interface RestrauntClient {
    @GetMapping("/api/restraunts/menu/{menuItemId}")
    MenuItemResponse getMenuItem(@PathVariable("menuItemId") Long menuItemId);
}
