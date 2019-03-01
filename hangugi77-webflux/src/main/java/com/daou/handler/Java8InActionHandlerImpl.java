package com.daou.handler;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.stream.LongStream;

@Service
public class Java8InActionHandlerImpl implements Java8InActionHandler {
    @Override
    public Mono<ServerResponse> parallel(ServerRequest serverRequest) {
        return ServerResponse.ok().body(BodyInserters.fromObject(LongStream.rangeClosed(1, 1000).parallel().reduce(Long::sum)));
    }
}
