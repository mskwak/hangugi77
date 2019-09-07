package com.daou.cloud.zuul.config;

import com.daou.cloud.zuul.filters.pre.SimpleFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulFilterConfig {
	@Bean
	public SimpleFilter simpleFilter() {
		return new SimpleFilter();
	}
}