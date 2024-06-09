package com.example.billing.commons.clients.config;

import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ClientConfiguration {
    @Value(value = "${security.internal-username}")
    private String internalUsername;

    @Bean
    public RequestInterceptor interceptor() {
        return requestTemplate -> requestTemplate.header("username", internalUsername);
    }
}
