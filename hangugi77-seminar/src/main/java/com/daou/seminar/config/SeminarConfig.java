package com.daou.seminar.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeminarConfig {
    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration
                .builder()
                .host("localhost")
                .database("test")
                .username("postgres")
                .password("ffff")
                .build();

        return new PostgresqlConnectionFactory(configuration);
    }
}