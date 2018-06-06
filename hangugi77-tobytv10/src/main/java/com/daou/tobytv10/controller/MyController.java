package com.daou.tobytv10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestOperations;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class MyController {
    private static final String URL1 = "http://daum.net";
    private static final String URL2 = "http://naver.com";
    private AsyncRestTemplate rt = new AsyncRestTemplate();

    @Autowired
    private MyService myService;

    @GetMapping("/rest/{idx}")
    public DeferredResult<String> rest(@PathVariable int idx) {
        System.out.println("1=" + Thread.currentThread().getName());

        DeferredResult<String> dr = new DeferredResult<>();

        ListenableFuture<ResponseEntity<String>> f1 = rt.getForEntity(URL1, String.class);

        f1.addCallback(s -> {
            System.out.println("2=" + Thread.currentThread().getName());
            ListenableFuture<ResponseEntity<String>> f2 = rt.getForEntity(URL2, String.class);

            f2.addCallback(s2 -> {
                System.out.println("3=" + Thread.currentThread().getName());
//                ListenableFuture<String> f3 = myService.work(s2.getBody());
                ListenableFuture<String> f3 = myService.work("1234");

                f3.addCallback(s3 -> {
                    System.out.println("4=" + Thread.currentThread().getName());
                    dr.setResult(s3);
                }, e3 -> {
                    dr.setErrorResult(e3.getMessage());
                });

            }, e2 -> {
                dr.setErrorResult(e2.getMessage());
            });
        }, e -> {
            dr.setErrorResult(e.getMessage());
        });

        System.out.println("5=" + Thread.currentThread().getName());

        return dr;
    }

    @Service
    public static class MyService {
        @Async
        public ListenableFuture<String> work(String req) {
            return new AsyncResult<>(req + "/asyncwork");
        }
    }
}
