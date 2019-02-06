package com.daou.session.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

import javax.servlet.ServletContext;

@Configuration

/*
    https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html 에는 설정 가능한 프로퍼티가 정리되어 있다
    위 링크의 SPRING SESSION XXXXX 에서 설정 가능한 프로퍼티가 있으며, @EnableRedisHttpSession 는 몇몇 프로퍼티에 대한 기본값을 정의해 놓은 것이다.
    @EnableRedisHttpSession 의 기본값이 아닌 값을 사용하고자 한다면 @EnableRedisHttpSession 을 설정하지 말고 application.properties 파일을 직접 설정하면 된다.
 */
@EnableRedisHttpSession
public class RedisHttpSessionConfig extends AbstractHttpSessionApplicationInitializer {
//    jedis, lettuce 모두 자바용 redis 클라이언트이다.
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName("localhost");
//        redisStandaloneConfiguration.setPort(6379);
//        return new JedisConnectionFactory(redisStandaloneConfiguration);
//    }

    @Override
    protected void beforeSessionRepositoryFilter(ServletContext servletContext) {
        System.out.println("beforeSessionRepositoryFilter");
    }

    @Bean
    public LettuceConnectionFactory connectionFactory() {
//      RedisStandaloneConfiguration 이외의 설정 가능한 파라미터는 ctrl + q 도움말에서 확인 가능하다
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName("localhost");
        redisStandaloneConfiguration.setPort(6379);
        return new LettuceConnectionFactory(redisStandaloneConfiguration);
     }

    /*
        커스텀 쿠키를 만드는 방법에 대한 링크
        https://docs.spring.io/spring-session/docs/1.3.3.RELEASE/reference/html5/guides/custom-cookie.html
    */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
        serializer.setCookieName("hangugiId");
        serializer.setCookiePath("/");
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$");
        serializer.setUseBase64Encoding(false);
        return serializer;
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}