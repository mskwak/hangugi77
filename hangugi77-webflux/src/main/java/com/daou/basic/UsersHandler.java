package com.daou.basic;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Component
public class UsersHandler {
//	@Autowired
//	private UsersRepository usersRepository;

	public Mono<ServerResponse> echo1(ServerRequest request) {
		System.out.println("222: " + Thread.currentThread().getId());
		//return ServerResponse.ok().body(request.bodyToMono(String.class), String.class);
		//Mono.just("Hello Reactive").map(s -> s.toUpperCase()).publishOn(Schedulers.newSingle("xxxxx")).log();

		return ServerResponse.ok().body(BodyInserters.fromObject(Mono.just("Hello Reactive").map(s -> s.toUpperCase()).publishOn(Schedulers.newSingle("xxxxx")).log()));
	}

//	public Mono<ServerResponse> echo2(ServerRequest request) {
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(Users.class));
//	}
//
//	public Mono<ServerResponse> echo3(ServerRequest request) {
//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(new Users()));
//	}

//	public Mono<ServerResponse> echo4(ServerRequest request) {
//		String id = request.pathVariable("id");
//		Optional<Users> users = usersRepository.findById(Long.parseLong(id));
//		return ServerResponse.ok().body(BodyInserters.fromObject(users));
//	}

	public Mono<ServerResponse> json(ServerRequest request) {
		List<Integer> list = List.of(1, 2, 3);
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(list));
	}

//	public Mono<ServerResponse> delete(ServerRequest request) {
//		String id = request.pathVariable("id");
//		usersRepository.deleteById(Long.parseLong(id));
//		return ServerResponse.ok().syncBody(List.of(1, 2, 3));
//	}
	//	public Mono<ServerResponse> xx(ServerRequest request) {
	//		return ServerResponse.ok().body(request.)
	//	}

	//	public Mono<ServerResponse> put(ServerRequest request) {
	//		Flux<Hello> hello = this.helloRepository.findAll();
	//		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(hello, Hello.class);
	//	}

	//	@Bean
	//	public RouterFunction<ServerResponse> router() {
	//		return RouterFunctions.route(RequestPredicates.path("/hello"), this.helloHandler());
	//	}
}
