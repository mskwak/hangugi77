//package com.daou.security.config;

// https://stackoverflow.com/questions/24916894/serving-static-web-resources-in-spring-boot-spring-security-application

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