package com.daou.controller;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

@RestController
public class AsyncTestController {
    @RequestMapping("/hello")
    public Mono<String> hello() {
        System.out.println("hello: " + Thread.currentThread().getName());
        return Mono
                .just("Hello Reactive")
                .map(s -> s.toUpperCase())
                .log()
                .publishOn(Schedulers.newSingle("publishOn"))
                .log();
    }

    @RequestMapping("/hello2")
    public CompletableFuture<String> hello2() {
        System.out.println("hello2: " + Thread.currentThread().getName());

        return CompletableFuture.supplyAsync(() -> {
            System.out.println("hello2-1: " + Thread.currentThread().getName());
            return "hello world";
        }).thenApplyAsync(s -> {
            System.out.println("hello2-2: " + Thread.currentThread().getName());
            return s.toUpperCase();
        });
    }

    @RequestMapping("/hello3")
    public Publisher<String> hello3(String name) {
        System.out.println("hello3: " + Thread.currentThread().getName());
        return new Publisher<String>() {
            @Override
            public void subscribe(Subscriber<? super String> s) {
                s.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {
                        s.onNext("hello3 " + name);
                        s.onComplete();
                    }

                    @Override
                    public void cancel() {

                    }
                });
            }
        };
    }
}
