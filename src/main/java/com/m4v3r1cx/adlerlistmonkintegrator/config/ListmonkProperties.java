package com.m4v3r1cx.adlerlistmonkintegrator.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "listmonk")
@Data
public class ListmonkProperties {
    private String url;
    private String username;
    private String passwd;
}
