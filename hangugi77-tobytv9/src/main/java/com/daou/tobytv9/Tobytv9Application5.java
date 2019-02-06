package com.daou.tobytv9;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Tobytv9Application5 {
	@RestController
	public static class MyController5 {
		AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

		static final String URL1 = "http://localhost:8081/service?req={req}";
		static final String URL2 = "http://localhost:8081/service2?req={req}";

		@GetMapping("/rest5")
		public DeferredResult<String> rest5(int idx) {
			DeferredResult<String> dr = new DeferredResult<>();
			ListenableFuture<ResponseEntity<String>> f1 = rt.getForEntity(URL1, String.class,"hello" + idx);

			f1.addCallback(s1 -> {
				ListenableFuture<ResponseEntity<String>> f2 = rt.getForEntity(URL2, String.class,idx);

				f2.addCallback(s2 -> {
					dr.setResult(s1.getBody() + "/" + s2.getBody());
				}, e2 -> {
					dr.setErrorResult(e2);
				});
			}, e -> {
				dr.setErrorResult(e);
			});

			return dr;
		}
	}

	@Bean
	public EventLoopGroup eventLoopGroup() {
		return new NioEventLoopGroup(3, new CustomizableThreadFactory("mskw"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Tobytv9Application5.class, args);
	}
}
