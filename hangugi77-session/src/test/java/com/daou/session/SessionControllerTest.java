package com.daou.session;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class SessionControllerTest {
    private Jedis jedis;
    private TestRestTemplate testRestTemplate;
    private TestRestTemplate testRestTemplateWithAuth;
    private String testUrl = "http://localhost:8080/";

    @Before
    public void clearRedisData() {
        testRestTemplate = new TestRestTemplate();
        testRestTemplateWithAuth = new TestRestTemplate("admin", "password", null);

        jedis = new Jedis("localhost", 6379);
//        jedis.flushAll();
    }

    @Test
    public void clear() {
        jedis.flushAll();
    }

    @Test
    public void testRedisIsEmpty() {
        Set<String> result = jedis.keys("*");
        Assert.assertEquals(0, ((Set) result).size());
    }

    @Test
    public void testUnauthenticatedCantAccess() {
        ResponseEntity<String> result = testRestTemplate.getForEntity(testUrl, String.class);
        Assert.assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
}

    @Test
    public void testRedisControlsSession() {
//        ResponseEntity<String> result = testRestTemplateWithAuth.getForEntity(testUrl, String.class);
//        Assert.assertEquals("hello admin", result.getBody());
//        System.out.println(result.getStatusCode());
//        result.getHeaders().keySet().stream().forEach(System.out::println);

        Set<String> redisResult = jedis.keys("*");
        redisResult.stream().forEach(System.out::println);

    }
}
