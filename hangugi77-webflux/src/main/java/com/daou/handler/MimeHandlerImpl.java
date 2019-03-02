package com.daou.handler;

import com.daou.domain.Mime;
import com.daou.service.core.MimeParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Component
public class MimeHandlerImpl implements MimeHandler {
    @Autowired
    private MimeParserService mimeParserService;

    @Override
    public Mono<ServerResponse> getMimeStructure(ServerRequest serverRequest) {
        List<Mime> mimeList = new ArrayList<>();

        Mono<MultiValueMap<String, Part>> multiValueMapMono = serverRequest.multipartData();

//        serverRequest.body(BodyExtractors.toMultipartData()).flatMap(multiValueMap -> {
//            Map<String, Part> map = multiValueMap.toSingleValueMap();
//
//            map.keySet().stream().forEach(name -> {
//                Part part = map.get(name);
//                part.content().flatMap(dataBuffer -> {
//                    InputStream inputStream = dataBuffer.asInputStream();
//                    try {
//                        MimeMessage mimeMessage = new MimeMessage(null, inputStream);
//                        String x = mimeParserService.getStructure(mimeMessage);
//                    } catch (MessagingException e) {
//                        e.printStackTrace();
//                    }
//
//                    return null;
//                });
//
//
//            });
//        });

        return ServerResponse.ok().body(BodyInserters.fromObject(mimeList));
    }
}
