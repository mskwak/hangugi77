package com.daou.tobytv7.pub;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PublisherOperator implements Publisher<String> {
    private Publisher publisher;

    public PublisherOperator(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void subscribe(Subscriber<? super String> s) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            publisher.subscribe(s);
        });
    }
}
