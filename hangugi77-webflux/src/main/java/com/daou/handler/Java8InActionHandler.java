package com.daou.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface Java8InActionHandler {
    public Mono<ServerResponse> parallel(ServerRequest serverRequest);
}
