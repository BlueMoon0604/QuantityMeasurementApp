package com.spring.userservice.config;

import com.spring.userservice.security.jwt.JwtAuthenticationFilter;
import com.spring.userservice.security.jwt.OAuth2AuthenticationSuccessHandler;
import com.spring.userservice.security.jwt.OAuth2FailureHandler;
import com.spring.userservice.service.CustomOAuth2UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtFilter;
    private final CustomOAuth2UserService oauth2UserService;
    private final OAuth2AuthenticationSuccessHandler successHandler;
    private final OAuth2FailureHandler failureHandler;

    public SecurityConfig(JwtAuthenticationFilter jwtFilter,
                          CustomOAuth2UserService oauth2UserService,
                          OAuth2AuthenticationSuccessHandler successHandler,
                          OAuth2FailureHandler failureHandler) {
        this.jwtFilter = jwtFilter;
        this.oauth2UserService = oauth2UserService;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",
                    "/api/auth/login",
                    "/api/auth/register",
                    "/oauth2/**",
                    "/login/**",
                    "/error",
                    "/h2-console/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex
                .authenticationEntryPoint((request, response, authException) -> {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.setContentType("application/json");
                    response.getWriter().write("{\"authenticated\":false,\"message\":\"Unauthorized\"}");
                })
            )
            .oauth2Login(oauth -> oauth
                .userInfoEndpoint(user -> user.userService(oauth2UserService))
                .successHandler(successHandler)
                .failureHandler(failureHandler)
            );

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}