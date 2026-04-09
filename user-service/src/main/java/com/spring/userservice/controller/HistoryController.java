package com.spring.userservice.controller;

import com.spring.userservice.dto.ConversionHistoryRequest;
import com.spring.userservice.dto.ConversionHistoryResponse;
import com.spring.userservice.entity.User;
import com.spring.userservice.repository.UserRepository;
import com.spring.userservice.service.HistoryService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    private final HistoryService historyService;
    private final UserRepository userRepository;

    public HistoryController(HistoryService historyService, UserRepository userRepository) {
        this.historyService = historyService;
        this.userRepository = userRepository;
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ConversionHistoryResponse saveHistory(
            Authentication authentication,
            @RequestBody ConversionHistoryRequest request) {

        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("User not authenticated");
        }

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return historyService.saveHistory(user.getId(), request);
    }
    @GetMapping("/my")
    public List<ConversionHistoryResponse> getMyHistory(Authentication authentication) {

        if (authentication == null || authentication.getName() == null) {
            throw new RuntimeException("User not authenticated");
        }

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return historyService.getUserHistory(user.getId());
    }
}