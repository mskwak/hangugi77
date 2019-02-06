//package com.daou.tobytv9;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootApplication
//public class Tobytv9Application {
//	@RestController
//	public static class MyController {
//		RestTemplate rt = new RestTemplate();
//
//		@GetMapping("/rest")
//		public String rest(int idx) {
//			String result = rt.getForObject("http://localhost:8081/service?req={req}", String.class,"hello" + idx);
//			return result;
//		}
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Tobytv9Application.class, args);
//	}
//}
