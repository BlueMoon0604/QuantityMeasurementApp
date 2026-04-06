package com.measurement.demo.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/")
    public String home() {
        return "Backend is running";
    }

    @GetMapping("/api/auth/me")
    public Map<String, Object> currentUser(Principal principal) {
        Map<String, Object> response = new HashMap<>();
        response.put("authenticated", principal != null);
        response.put("principal", principal != null ? principal.getName() : null);
        return response;
    }
}