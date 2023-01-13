package com.example.githublogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable {

        http.oauth2Login();
        http.authorizeHttpRequests()
                .anyRequest()
                .authenticated();

        return http.build();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(){
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider
                .GITHUB
                .getBuilder("github")
                .clientId("ccbfa4773a93a8873a60")
                .clientSecret("4820a61c2e0fa23866576b19b8b533b730b89942")
                .build();
    }
}
