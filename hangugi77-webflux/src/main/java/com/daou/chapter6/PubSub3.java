package com.daou.chapter6;

import reactor.core.publisher.Flux;

public class PubSub3 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Flux.<Integer>create(e -> {
			System.out.println(Thread.currentThread().getName());
			e.next(1);
			e.next(2);
			e.next(3);
			e.complete();
		})
		.log()
		.map(s -> s * 10)
		.log()
		.subscribe((s) -> System.out.println(Thread.currentThread().getName()));
	}
}
