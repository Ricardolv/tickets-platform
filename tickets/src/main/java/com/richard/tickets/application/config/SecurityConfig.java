package com.richard.tickets.application.config;

import com.richard.tickets.application.security.filters.UserProvisiongFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                        UserProvisiongFilter userProvisiongFilter) throws Exception {

        http
                .authorizeHttpRequests(authotise ->
                        // Catch all rules
                        authotise.anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2 ->
                        oauth2.jwt(
                                Customizer.withDefaults()
                        ))
                .addFilterAfter(userProvisiongFilter, BearerTokenAuthenticationFilter.class);

        return http.build();
    }
}
