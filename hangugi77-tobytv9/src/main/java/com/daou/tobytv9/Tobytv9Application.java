package com.daou.tobytv9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Tobytv9Application {
	@RestController
	public static class MyController {
		@GetMapping("/rest")
		public String rest() {
			return "rest";
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(Tobytv9Application.class, args);
	}
}
