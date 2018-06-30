package com.daou.tobytv9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Tobytv9Application2 {
	@RestController
	public static class MyController2 {
		AsyncRestTemplate rt = new AsyncRestTemplate();

		@GetMapping("/rest2")
		public ListenableFuture<ResponseEntity<String>> rest2(int idx) {
			ListenableFuture<ResponseEntity<String>> result = rt.getForEntity("http://localhost:8081/service?req={req}", String.class,"hello" + idx);
			return result;
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Tobytv9Application2.class, args);
	}
}
