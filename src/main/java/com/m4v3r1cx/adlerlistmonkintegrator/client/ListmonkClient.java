package com.m4v3r1cx.adlerlistmonkintegrator.client;

import com.m4v3r1cx.adlerlistmonkintegrator.config.ListmonkProperties;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ListmonkClient {

    private final ListmonkProperties properties;

    private RestClient restClient;

    @PostConstruct
    public void init() {
        this.restClient = RestClient.builder().baseUrl(properties.getUrl()).defaultHeaders(
                headers -> headers.setBasicAuth(properties.getUsername(), properties.getPasswd()))
                .build();
    }

    public Object getLists() {
        return restClient.get()
                .uri("/api/lists")
                .retrieve()
                .body(Object.class);
    }

    public Map<String, Object> createSubscriber(String email, String name, List<Integer> lists) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", email);
        payload.put("name", name);
        payload.put("status", "enabled");
        payload.put("lists", lists);

        return restClient.post()
                .uri("/api/subscribers")
                .body(payload)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}