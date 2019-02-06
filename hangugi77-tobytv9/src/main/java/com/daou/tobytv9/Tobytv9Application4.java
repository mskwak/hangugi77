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
//import org.springframework.web.context.request.async.DeferredResult;
//
//@SpringBootApplication
//public class Tobytv9Application4 {
//	@RestController
//	public static class MyController4 {
//		AsyncRestTemplate rt = new AsyncRestTemplate(new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));
//
//		@GetMapping("/rest4")
//		public DeferredResult<String> rest4(int idx) {
//			DeferredResult<String> dr = new DeferredResult<>();
//			ListenableFuture<ResponseEntity<String>> f1 = rt.getForEntity("http://localhost:8081/service?req={req}", String.class,"hello" + idx);
//
//			f1.addCallback(s -> {
//				dr.setResult(s.getBody() + "/work");
//			}, e -> {
//				dr.setErrorResult(e.getMessage());
//			});
//
//			return dr;
//		}
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Tobytv9Application4.class, args);
//	}
//}
