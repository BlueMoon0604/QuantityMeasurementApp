package com.spring.apigateway.util;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class RouteValidator {

    public boolean isSecured(ServerWebExchange exchange) {
        String path = exchange.getRequest().getURI().getPath();

        return !(
                path.startsWith("/user/api/auth/")
                || path.startsWith("/user/oauth2/")
                || path.startsWith("/user/login/")
                || path.startsWith("/login/oauth2/")
                || path.startsWith("/user/error")
                || path.startsWith("/oauth2")
                || path.startsWith("/login")
                || path.startsWith("/eureka")
        );
    }
}