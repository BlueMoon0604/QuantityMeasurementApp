package com.spring.apigateway.util;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

@Component
public class RouteValidator {

    public boolean isSecured(ServerWebExchange exchange) {
        String path = exchange.getRequest().getURI().getPath();

        if (path.startsWith("/api/auth/")
                || path.startsWith("/oauth2")
                || path.startsWith("/login")
                || path.startsWith("/api/v1/quantities/count/")
                || path.startsWith("/api/v1/quantities/history/type/")
                || path.startsWith("/api/v1/quantities/history/operation/")) {
            return false;
        }

        return true;
    }
}