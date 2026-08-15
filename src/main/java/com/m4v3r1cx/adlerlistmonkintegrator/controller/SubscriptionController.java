package com.m4v3r1cx.adlerlistmonkintegrator.controller;

import com.m4v3r1cx.adlerlistmonkintegrator.dto.SubscriberDTO;
import com.m4v3r1cx.adlerlistmonkintegrator.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<?> subscribe(@RequestBody SubscriberDTO request) {
        return ResponseEntity.ok(subscriptionService.subscribe(request));
    }
}
