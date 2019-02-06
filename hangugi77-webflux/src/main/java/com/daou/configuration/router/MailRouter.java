package com.daou.configuration.router;

import com.daou.handler.MailHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MailRouter {
    @Bean
    public RouterFunction<ServerResponse> mailRouterTable(MailHandler mailHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/mail/mime/struct"), mailHandler::parseMime);
    }
}
