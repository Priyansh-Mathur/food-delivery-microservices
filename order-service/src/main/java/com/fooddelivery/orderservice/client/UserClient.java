package com.fooddelivery.orderservice.client;

import com.fooddelivery.orderservice.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {
    @GetMapping("/api/users/email/{email}")
    UserResponse getUserByEmail(@PathVariable("email") String email);
}
