package com.daou.security.config;

import com.daou.security.encoder.TestPlainPasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public TestPlainPasswordEncoder testPlainPasswordEncoder() {
        return new TestPlainPasswordEncoder();
    }
}
