package com.daou.seminar.config;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SeminarConfig {
    @Autowired
    private Environment e;

    @Bean
    PostgresqlConnectionFactory connectionFactory() {
        PostgresqlConnectionConfiguration configuration = PostgresqlConnectionConfiguration
                .builder()
                .host(e.getProperty("db.host"))
                .database(e.getProperty("spring.datasource.name")) // 잘못된 DB 이름을 넣어도 실행 성공, 주석 처리해도 실행 성공
                .username(e.getProperty("spring.datasource.username"))
                .password(e.getProperty("spring.datasource.password"))
                .build();

        return new PostgresqlConnectionFactory(configuration);
    }
}