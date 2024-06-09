package com.example.gateway.config;

import com.example.gateway.filter.AuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth", r -> r.path("/api/v1/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth"))

                .route("user", r -> r.path("/api/v1/user/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user"))

                .route("billing-card", r -> r.path("/api/v1/card/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://billing"))

                .route("billing-operation", r -> r.path("/api/v1/operation/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://billing"))

                .route("billing-operation", r -> r.path("/api/v1/transaction/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://billing"))
                .build();
    }

}
