package com.daou.seminar.controller;

import com.daou.seminar.model.Customer;
import com.daou.seminar.service.SeminarService;
import io.r2dbc.spi.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
@Slf4j
public class HelloWorld {
	@Autowired
	private SeminarService seminarService;

//	@GetMapping("/hello")
//	public Mono<String> helloWorld() {
//		return Mono.just("Hello World").log().delayElement(Duration.ofSeconds(1)).log().doAfterSuccessOrError((s, t) -> {
//			System.out.println(Thread.currentThread().getName() + ":" + s);
//			System.out.println(Thread.currentThread().getName() + ":" + t);
//		}).log().map(String::toUpperCase).log().cancelOn(Schedulers.immediate()).log();
//	}

	@GetMapping("/create")
	public Flux<Result> create() {
		return seminarService.create(Long.valueOf("1"), "mskw");
	}

	@GetMapping("/delete")
	public Flux<Result> delete() {
		return  seminarService.delete(Long.valueOf("1"));
	}

	@GetMapping("/all")
	public Flux<Customer> all() {
		return  seminarService.all();
	}
}
