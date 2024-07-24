package com.socialapp.gatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/api/users/**")
                        .uri("lb://USER-SERVICE")
                ).route("post-service", r -> r.path("/api/posts/**")
                        .uri("lb://POST-SERVICE")
                ).route("file-service", r -> r.path("/api/files/**")
                        .uri("lb://FILE-SERVICE")
                ).route("interaction-service", r -> r.path("/api/interactions/**")
                        .uri("lb://INTERACTION-SERVICE")
                )
                .build();
    }
}
