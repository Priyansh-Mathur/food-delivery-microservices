package com.fooddelivery.userservice.controller;

import com.fooddelivery.userservice.dto.AuthResponse;
import com.fooddelivery.userservice.dto.LoginRequest;
import com.fooddelivery.userservice.dto.RegisterRequest;
import com.fooddelivery.userservice.dto.UserResponse;
import com.fooddelivery.userservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/me")
    public UserResponse me(@RequestHeader("X-User-Email") String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/email/{email}")
    public UserResponse getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return userService.getById(id);
    }
}
