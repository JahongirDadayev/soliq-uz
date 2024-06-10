package com.example.gateway.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/verification",
            "/auth/login"
    );

    public static final Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}
