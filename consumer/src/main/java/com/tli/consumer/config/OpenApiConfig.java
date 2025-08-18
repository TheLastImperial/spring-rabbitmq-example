package com.tli.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Value("${spring.application.name}")
    private String title;
    @Value("${spring.application.version}")
    private String version;
    @Value("${spring.application.description}")
    private String description;
    
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().info(
            new Info().title(title)
            .version(version)
            .description(description)
        );
    }
}
