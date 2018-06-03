package com.daou.seminar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

@RestController
@Slf4j
public class HelloWorld {
	@GetMapping("/helloworld")
	public Mono<String> helloWorld() {
		return Mono.just("Hello World").log().delayElement(Duration.ofSeconds(1)).log().doAfterSuccessOrError((s, t) -> {
			System.out.println(Thread.currentThread().getName() + ":" + s);
			System.out.println(Thread.currentThread().getName() + ":" + t);
		}).log().map(String::toUpperCase).log().cancelOn(Schedulers.immediate()).log();
	}
}
