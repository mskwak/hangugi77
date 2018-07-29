package com.daou.cloud.zuul;

import com.daou.cloud.zuul.filters.pre.SimpleFilter;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.commons.httpclient.ApacheHttpClientFactory;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

//    @Bean
//    public ApacheHttpClientFactory apacheHttpClientFactory() {
//        return new ApacheHttpClientFactory() {
//            @Override
//            public HttpClientBuilder createBuilder() {
//                return HttpClientBuilder.create()
//                        .disableContentCompression()
//                        .disableCookieManagement()
//                        .useSystemProperties()
//                        .disableRedirectHandling();
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
