package com.example.loginApp.Supports;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestKeycloak {
	
    private String clientId = "login-app";
    
    private String authUrl = "http://localhost:8080/auth";
    
    private String realm="SpringBootKeycloak";
    
    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
            .grantType(OAuth2Constants.PASSWORD)
            .serverUrl(authUrl)
            .realm(realm)
            .clientId(clientId)
            .username("mb@keycloak.com")
            .password("password")
            .build();
    }
}
