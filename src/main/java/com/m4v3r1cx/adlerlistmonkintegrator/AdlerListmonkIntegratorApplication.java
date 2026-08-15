package com.m4v3r1cx.adlerlistmonkintegrator;

import com.m4v3r1cx.adlerlistmonkintegrator.config.ListmonkProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ListmonkProperties.class)
public class AdlerListmonkIntegratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(AdlerListmonkIntegratorApplication.class, args);
	}
}
