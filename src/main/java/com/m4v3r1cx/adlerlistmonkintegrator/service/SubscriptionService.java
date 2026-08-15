package com.m4v3r1cx.adlerlistmonkintegrator.service;

import com.m4v3r1cx.adlerlistmonkintegrator.client.ListmonkClient;
import com.m4v3r1cx.adlerlistmonkintegrator.dto.SubscriberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final ListmonkClient listmonkClient;

    public Object subscribe(SubscriberDTO subscriberDTO) {
        return listmonkClient.createSubscriber(subscriberDTO.getEmail(), subscriberDTO.getName(), List.of(1));
    }
}
