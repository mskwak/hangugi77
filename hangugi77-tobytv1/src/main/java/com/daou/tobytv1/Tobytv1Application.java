package com.daou.tobytv1;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CompletableFuture;

@EnableWebFlux
@SpringBootApplication
public class Tobytv1Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Tobytv1Application.class);

        //		try(ConfigurableApplicationContext c = springApplication.run(args)) {
        //		}

        ConfigurableApplicationContext c = springApplication.run(args);
    }

//    @Bean
//    public ServletWebServerFactory servletWebServerFactory() {
//        return new TomcatServletWebServerFactory();
//    }

    @Bean
    public CommandLineRunner run1() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("run11111...");
            }
        };
    }

    @Bean
    public ApplicationRunner run2() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
                System.out.println("run22222...");
            }
        };
    }

    @RestController
    public static class MyController {
        @RequestMapping("/hello")
        public Mono<String> hello() {
            System.out.println("111111111111: " + Thread.currentThread().getName());
            return Mono
                    .just("Hello Reactive")
                    .map(s -> s.toUpperCase())
                    .log()
                    .publishOn(Schedulers.newSingle("publishOn"))
                    .log();
        }

        @GetMapping("/hello2")
        public CompletableFuture<String> hello2() {
            System.out.println("111111111111: " + Thread.currentThread().getName());

            return CompletableFuture.supplyAsync(() -> {
                System.out.println("222222222222: " + Thread.currentThread().getName());
                return "hello world";
            }).thenApplyAsync(s -> {
                System.out.println("333333333333: " + Thread.currentThread().getName());
                return s.toUpperCase();
            }).thenApplyAsync(s -> {
                System.out.println("444444444444: " + Thread.currentThread().getName());
                return s.toLowerCase();
            });
        }

        @RequestMapping("/hello3/{name}")
        public Publisher<String> hello3(@PathVariable  String name) {
            System.out.println("111111111111: " + Thread.currentThread().getName());

            return new Publisher<String>() {
                public void sout() {
                    System.out.println("222222222222: " + Thread.currentThread().getName());
                }

                @Override
                public void subscribe(Subscriber<? super String> s) {
                	sout();

                    s.onSubscribe(new Subscription() {
                        @Override
                        public void request(long n) {
                            s.onNext("Hello " + name);
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
}
