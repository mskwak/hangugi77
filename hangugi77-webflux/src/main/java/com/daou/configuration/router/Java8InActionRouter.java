package com.daou.configuration.router;

import com.daou.handler.Java8InActionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Java8InActionRouter {
    @Bean
    public RouterFunction<ServerResponse> java8inaction(Java8InActionHandler java8InActionHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/parallel"), java8InActionHandler::parallel);
    }
}
