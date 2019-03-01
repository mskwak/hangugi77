package com.daou.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface MimeHandler {
    public Mono<ServerResponse> getMimeStructure(ServerRequest serverRequest);
}
