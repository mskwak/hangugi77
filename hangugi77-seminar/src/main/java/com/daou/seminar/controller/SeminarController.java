package com.daou.seminar.controller;

import com.daou.seminar.entity.Customer;
import com.daou.seminar.service.SeminarService;
import io.r2dbc.spi.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@Slf4j
public class SeminarController {
	@Autowired
	private SeminarService seminarService;

//	@GetMapping("/hello")
//	public Mono<String> helloWorld() {
//		return Mono.just("Hello World").log().delayElement(Duration.ofSeconds(1)).log().doAfterSuccessOrError((s, t) -> {
//			System.out.println(Thread.currentThread().getName() + ":" + s);
//			System.out.println(Thread.currentThread().getName() + ":" + t);
//		}).log().map(String::toUpperCase).log().cancelOn(Schedulers.immediate()).log();
//	}

	@PostMapping("/create")
	public Flux<Result> create() {
		return seminarService.create(Long.valueOf("1"), "mskw");
	}

	@PostMapping("/delete/{id}")
	public Flux<Result> delete(@PathVariable Long id) {
		return  seminarService.delete(id);
	}

	@PutMapping("modify/{id}")
	public Flux<Result> modifyPut(@PathVariable Long id) {
		return  seminarService.delete(id);
	}

	@GetMapping("modify/{id}")
	public Flux<Result> modifyGet(@PathVariable Long id) {
		return  seminarService.delete(id);
	}

	@GetMapping("/all")
	public Flux<Customer> all() {
		return  seminarService.all();
	}
}
