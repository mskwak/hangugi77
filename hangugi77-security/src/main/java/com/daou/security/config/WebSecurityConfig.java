package com.daou.security.config;

// https://stackoverflow.com/questions/24916894/serving-static-web-resources-in-spring-boot-spring-security-application

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

// 샘플 URL: https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
// 샘플 URL: https://gs.saro.me/#!m=elec&jn=790

@Configuration // WebSecurityConfigurerAdapter 상속해서 configure 메소드 overide 할 경우 @Configuration 는 필수다. @Configuration을 설정하지 않으면 아래 configure 메소드가 동작하지 않는다.
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static String USER_QUERY = "SELECT email, password, active FROM user WHERE email = ?";
    private final static String ROLE_QUERY = "SELECT u.email, r.role FROM user u INNER JOIN user_role ur ON(u.user_id=ur.user_id) INNER JOIN role r ON(ur.role_id=r.role_id) WHERE u.email=?";
//
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .usersByUsernameQuery(USER_QUERY)
                .authoritiesByUsernameQuery(ROLE_QUERY)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);

//            auth.inMemoryAuthentication().withUser("user").password("ffff").roles("USER")
//                    .and().withUser("admin").password("ffff").roles("ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/registration").permitAll()
            .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
            .authenticated().and().csrf().disable().formLogin()
            .loginPage("/login").failureUrl("/login?error=true")
            .defaultSuccessUrl("/admin/home")
            .usernameParameter("email")
            .passwordParameter("password")
            .and().logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/").and().exceptionHandling()
            .accessDeniedPage("/access-denied");


//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login").permitAll()
//                .anyRequest().authenticated();
//
//        http.csrf().disable();
//
//        http.formLogin()
//                .loginPage("/login")
//                .failureForwardUrl("/error")
//                .successForwardUrl("/home")
//                .defaultSuccessUrl("/home");


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.debug(false).ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**", "/h2/**", "/images/**");
    }
}


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
