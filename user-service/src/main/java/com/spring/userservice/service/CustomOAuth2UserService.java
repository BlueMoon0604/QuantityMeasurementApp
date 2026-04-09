package com.spring.userservice.service;

import com.spring.userservice.entity.User;
import com.spring.userservice.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.*;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauthUser = super.loadUser(userRequest);

        Map<String, Object> attributes = oauthUser.getAttributes();

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");
        String providerId = String.valueOf(attributes.get("sub"));

        Optional<User> existingUser = userRepository.findByEmail(email);

        User user;
        if (existingUser.isPresent()) {
            user = existingUser.get();

            if (user.getName() == null || user.getName().isBlank()) {
                user.setName(name);
            }
            if (user.getProvider() == null || user.getProvider().isBlank()) {
                user.setProvider("GOOGLE");
            }
            if (user.getProviderId() == null || user.getProviderId().isBlank()) {
                user.setProviderId(providerId);
            }
            if (user.getRole() == null || user.getRole().isBlank()) {
                user.setRole("ROLE_USER");
            }
        } else {
            user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(null);
            user.setProvider("GOOGLE");
            user.setProviderId(providerId);
            user.setRole("ROLE_USER");
            user.setEnabled(true);
        }

        userRepository.save(user);

        return new DefaultOAuth2User(
                java.util.Collections.singleton(new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                "email"
        );
    }
}