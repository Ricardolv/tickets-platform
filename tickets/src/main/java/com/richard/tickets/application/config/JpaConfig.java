package com.richard.tickets.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.richard.tickets.infrastructure.persistence.repositories")
@EnableJpaAuditing
public class JpaConfig {
}
