package com.daou.handler;

import com.daou.service.web.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class MailHandlerImpl implements MailHandler {
    @Autowired
    private MailService mailServiceImpl;

    @Override
    public Mono<ServerResponse> parseMime(ServerRequest serverRequest) {
        serverRequest.body(BodyExtractors.toMultipartData());
        return ServerResponse.ok().body(BodyInserters.fromObject("xxxxx"));
    }
}
