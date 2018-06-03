package com.daou.basic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Configuration
public class UsersRouter {
	@Bean
	public RouterFunction<ServerResponse> monoRouterFunction(UsersHandler usersHandler) {
		System.out.println("111: " + Thread.currentThread().getId());

		return RouterFunctions.route(RequestPredicates.GET("/echo1"), usersHandler::echo1)
				.andRoute(RequestPredicates.GET("/echo2"), usersHandler::echo2)
				.andRoute(RequestPredicates.GET("/echo3"), usersHandler::echo3)
				.andRoute(RequestPredicates.GET("/echo4/{id}"), usersHandler::echo4)
				.andRoute(RequestPredicates.GET("/json").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)) , usersHandler::json)
				.andRoute(RequestPredicates.POST("/echo"), usersHandler::echo1)
				.andRoute(RequestPredicates.PUT("/echo"), usersHandler::echo1)
				.andRoute(RequestPredicates.DELETE("/delete/{id}"), usersHandler::delete);
	}

	@Bean
	public RouterFunction<ServerResponse> routerAndHandler() {
		return RouterFunctions.route(RequestPredicates.path("/rah"), request -> ServerResponse.ok().body(BodyInserters.fromObject("routerAndHandler")));
	}

	@RequestMapping("/hello")
	public Mono<String> hello() {
		return Mono.just("hello reacitve").map(s -> s.toUpperCase()).publishOn(Schedulers.newSingle("xxxx")).log();
	}
}
