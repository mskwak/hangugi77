package com.daou.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface MailHandler {
    public Mono<ServerResponse> parseMime(ServerRequest serverRequest);
}
