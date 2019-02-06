package com.daou.tobytv10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@SpringBootApplication
public class Tobytv10Application {
    @RestController
    public static class MyController {
        @GetMapping("/rest")
        public Mono<String> rest() {
            test();
            return Mono.just("rest");
        }
    }

        public static void compute(String v) {
            try {
                System.out.println("compute integer v: " + v);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    public static void test() {
        Mono.just("test").subscribeOn(Schedulers.newElastic("test")).subscribe(Tobytv10Application::compute);
    }

    public static void main(String[] args) {
        SpringApplication.run(Tobytv10Application.class, args);
    }
}
