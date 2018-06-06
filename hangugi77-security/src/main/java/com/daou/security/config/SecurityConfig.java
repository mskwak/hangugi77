package com.daou.security.config;

// https://stackoverflow.com/questions/24916894/serving-static-web-resources-in-spring-boot-spring-security-application

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // WebSecurityConfigurerAdapter 상속해서 configure 메소드 overide 할 경우 @Configuration 는 필수다. @Configuration을 설정하지 않으면 아래 configure 메소드가 동작하지 않는다.
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/h2/**");
    }
}

//@EnableWebSecurity
//@EnableGlobalMethodSecurity
//@EnableGlobalAuthentication
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	http://java.ihoney.pe.kr/498
//	@Bean
//	public static PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}

//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//				.authorizeRequests()
//					.antMatchers("/css/**", "/index").permitAll()
//					.antMatchers("/user/**").hasRole("USER")
//				.and()
//				.formLogin()
//					.loginPage("/login")
//					.failureUrl("/login-error");
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.inMemoryAuthentication().withUser("mskw").password("{noop}ffff").roles("USER");
//	}

//	@Autowired
//	public  void confgiureGlobal2(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.jdbcAuthentication().dataSource().withUser()
//	}
//}
