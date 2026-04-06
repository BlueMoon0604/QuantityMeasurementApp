package com.measurement.demo.config;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.measurement.demo.security.jwt.JwtAuthenticationFilter;
import com.measurement.demo.security.jwt.OAuth2AuthenticationSuccessHandler;
import com.measurement.demo.security.jwt.OAuth2FailureHandler;
import com.measurement.demo.service.CustomOAuth2UserService;

@Configuration
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtFilter;
	private final CustomOAuth2UserService oauth2UserService;
	private final OAuth2AuthenticationSuccessHandler successHandler;
	private final OAuth2FailureHandler failureHandler;

	public SecurityConfig(JwtAuthenticationFilter jwtFilter, CustomOAuth2UserService oauth2UserService,
			OAuth2AuthenticationSuccessHandler successHandler, OAuth2FailureHandler failureHandler) {
		this.jwtFilter = jwtFilter;
		this.oauth2UserService = oauth2UserService;
		this.successHandler = successHandler;
		this.failureHandler = failureHandler;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())

				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/v1/users/**").permitAll() // login/register
						.requestMatchers("/oauth2/**").permitAll() // oauth endpoints
						.anyRequest().authenticated())

				// ✅ OAuth2 login config
				.oauth2Login(oauth -> oauth.userInfoEndpoint(user -> user.userService(oauth2UserService))
						.successHandler(successHandler).failureHandler(failureHandler));

		// ✅ Add JWT filter
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
	    return config.getAuthenticationManager();
	}

}