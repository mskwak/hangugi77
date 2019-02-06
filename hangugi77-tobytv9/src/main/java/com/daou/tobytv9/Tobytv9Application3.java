//package com.daou.tobytv9;
//
//import io.netty.channel.nio.NioEventLoopGroup;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.client.Netty4ClientHttpRequestFactory;
//import org.springframework.util.concurrent.ListenableFuture;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.AsyncRestTemplate;
//
//@SpringBootApplication
//public class Tobytv9Application3 {
//	@RestController
//	public static class MyController3{
//		AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));
//
//		@GetMapping("/rest3")
//		public ListenableFuture<ResponseEntity<String>> rest3(int idx) {
//			ListenableFuture<ResponseEntity<String>> result = rt.getForEntity("http://localhost:8081/service?req={req}", String.class,"hello" + idx);
//			return result;
//		}
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Tobytv9Application3.class, args);
//	}
//}
