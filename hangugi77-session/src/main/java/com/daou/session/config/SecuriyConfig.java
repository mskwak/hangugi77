package com.daou.session.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecuriyConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("admin")
                // java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
                // https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error 참고하여 해결함
                .password("{noop}password")
                .roles("ADMIN")
                    .and()
                .withUser("admin2")
                .password("{noop}password")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/")
//                .hasRole("ADMIN")
//                .anyRequest()
//                .authenticated();

        httpSecurity
                .authorizeRequests()
                    .anyRequest()
                    .authenticated()
                .and()
                    .formLogin();

    }
}
